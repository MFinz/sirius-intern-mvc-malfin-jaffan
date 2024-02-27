package com.malfin.crud.mobil.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.malfin.crud.mobil.entity.DetailMobil;
import com.malfin.crud.mobil.entity.Mobil;
import com.malfin.crud.mobil.entity.MobilAdapter;
import com.malfin.crud.mobil.repo.DetailMobilRepo;
import com.malfin.crud.mobil.repo.MobilRepo;
import com.malfin.crud.mobil.repo.WarnaRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MobilService {

  @Autowired
  private MobilRepo mobilRepo;

  @Autowired
  private WarnaRepo warnaRepo;

  @Autowired
  private DetailMobilRepo detailmobilRepo;

  public List<Mobil> findAll() {
    return mobilRepo.findAll();
  }

  public void addMobil(MobilAdapter mobiladapter) throws Exception {
    Mobil mobil = new Mobil();
    BeanUtils.copyProperties(mobiladapter.getMobil(), mobil);

    // Simpan objek Mobil ke database
    try {
      // Simpan objek Mobil ke database
      mobilRepo.save(mobil);

      List<DetailMobil> detailMobils = new ArrayList<>();

      // Proses setiap DetailMobil dari adapter dan tambahkan ke list
      for (MobilAdapter mobilAdapter : mobiladapter.getDetailMobilAdapters()) {
        Integer newIdDetail = generateNewDetailId();
        DetailMobil detailMobil = new DetailMobil();
        detailMobil.setId(newIdDetail);
        detailMobil.setMobil(mobil);
        detailMobil.setWarna(warnaRepo.getReferenceById(mobilAdapter.getIdWarna()));
        detailMobil.setTipeWarna(mobilAdapter.getTipeWarna());
        detailMobil.setDeskripsi(mobilAdapter.getDeskripsi());

        detailMobils.add(detailMobil);
      }

      // Simpan semua detail mobil sekaligus
      detailmobilRepo.saveAll(detailMobils);
    } catch (DataIntegrityViolationException e) {
      throw new Exception(
        "Terjadi kesalahan saat menyimpan data mobil: " + e.getMessage()
      );
    }
  }

  // // Mengecek bahwa data warna tidak boleh duplikat
  // for (DetailMobil detailMobil : detailMobilList) {
  //     Integer mobilId = detailMobil.getMobil().getId();
  //     Integer warnaId = detailMobil.getWarna().getId();

  //     Integer countSameIds = 0;
  //     for (DetailMobil dm : detailMobilList) {
  //         if (dm.getWarna().getId() == warnaId && dm.getMobil().getId() == mobilId) {
  //             countSameIds++;
  //         }
  //     }

  //     if (countSameIds > 1) {
  //         throw new Exception("Terjadi duplikat pada Warna!");
  //     }
  // }

  // Mengecek bahwa data tidak boleh sama persis dengan data yang sudah ada (Logika salah)

  // for (DetailMobil detailMobil : detailMobilList) {
  //         String merek = detailMobil.getMobil().getMerek();
  //         String model = detailMobil.getMobil().getModel();
  //         String tahunProduksi = detailMobil.getMobil().getTahunProduksi();
  //         char jumlahPintu = detailMobil.getMobil().getJumlahPintu();
  //         BigInteger harga = detailMobil.getMobil().getHarga();

  //         int countSameAttributes = 0;
  //         for (DetailMobil dm : detailMobilList) {
  //             if (mobil.getMerek().equals(merek) &&
  //                 mobil.getModel().equals(model) &&
  //                 (mobil.getTahunProduksi() == null ? tahunProduksi == null : mobil.getTahunProduksi().equals(tahunProduksi)) &&
  //                 mobil.getJumlahPintu() == jumlahPintu &&
  //                 mobil.getHarga().compareTo(harga) == 0) {
  //                 countSameAttributes++;
  //             }
  //         }

  //         if (countSameAttributes > 1) {
  //             throw new Exception("Data mobil yang diinput sudah ada!");
  //         }
  //     }

  //  try {
  //     mobilRepo.save(mobiladapter.getMobil());
  // } catch (DataIntegrityViolationException e) {
  //     throw new Exception("Terjadi kesalahan saat menyimpan data mobil: " + e.getMessage());
  // }

  public void deleteById(int id) {
    mobilRepo.deleteById(id);
  }

  public Mobil findById(int id) {
    return mobilRepo.getReferenceById(id);
  }

  public void updateMobil(MobilAdapter mobiladapter) throws Exception {
    Mobil mobil = mobiladapter.getMobil();

    for (MobilAdapter m : mobiladapter.getDetailMobilAdapters()) {
      // Periksa jika DetailMobil ada maka lakukan:

      // System.out.println("Id Detail:" + m.getIdDetail());
      if (m.getIdDetail() != 0) {
        DetailMobil detailMobil = detailmobilRepo.getReferenceById(
          m.getIdDetail()
        );
        detailMobil.setWarna(warnaRepo.getReferenceById(m.getIdWarna()));
        detailMobil.setTipeWarna(m.getTipeWarna());
        detailMobil.setDeskripsi(m.getDeskripsi());
        // System.out.println("Masuk ke dalam blok if");

        detailmobilRepo.save(detailMobil);
      }
      // Jika DetailMobil tidak ada maka lakukan:
      else {
        boolean detailExists = detailmobilRepo.existsByMobilIdAndWarnaId(
          mobil.getId(),
          m.getIdWarna()
        );
        if (detailExists) {
          System.out.println("Terjadi kesalahan");
        } else {
          // Periksa idWarna harus bukan 0
          // PeriksaTipeWarna harus ada
          if (m.getIdWarna() != 0 && m.getTipeWarna() != null) {
            Integer newIdDetail = generateNewDetailId();
            DetailMobil detailMobil = new DetailMobil();
            detailMobil.setId(newIdDetail);
            detailMobil.setMobil(mobil);
            detailMobil.setWarna(warnaRepo.getReferenceById(m.getIdWarna()));
            detailMobil.setTipeWarna(m.getTipeWarna());
            detailMobil.setDeskripsi(m.getDeskripsi());
            System.out.println("Masuk ke dalam blok else");

            detailmobilRepo.save(detailMobil);
          }
        }
      }
      // m.setMobil(mobil);
      // System.out.println(" >> "+m.getIdWarna() + " >> " +m.getTipeWarna()
      // + " >> " + m.getIdDetail());

    }

    try {
      // Simpan objek mobil yang telah diupdate ke dalam repository mobil
      mobilRepo.save(mobil);
    } catch (Exception e) {
      throw new Exception(
        "Terjadi kesalahan saat menyimpan data mobil: " + e.getMessage()
      );
    }
  }

  private Integer generateNewDetailId() {
    Integer maxId = detailmobilRepo.getMaxId();

    if (maxId == null) {
      return 1;
    }

    return maxId + 1;
  }
}
