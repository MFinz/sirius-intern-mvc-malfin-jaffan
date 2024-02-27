package com.malfin.crud.mobil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malfin.crud.mobil.entity.Mobil;
import com.malfin.crud.mobil.entity.Sedan;
import com.malfin.crud.mobil.repo.SedanRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SedanService {

  @Autowired
  private SedanRepo sedanRepo;

  public List<Sedan> findAll() {
    return sedanRepo.findAll();
  }

  public void addSedan(Sedan sedan) {
    sedanRepo.save(sedan);
  }

  // Untuk cek duplikat data
  public boolean existsByMobil(Mobil mobil) {
    return sedanRepo.existsByMobil(mobil);
  }

  public boolean existsById(Integer id) {
    return sedanRepo.existsById(id);
  }

  // Akhir skrip cek data

  public void deleteById(int id) {
    sedanRepo.deleteById(id);
  }

  public Sedan findById(int id) {
    return sedanRepo.getReferenceById(id);
  }

  public void updateSedan(Sedan sedan) {
    sedanRepo.save(sedan);
  }
}
