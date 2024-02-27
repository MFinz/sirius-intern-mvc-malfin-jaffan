package com.malfin.crud.mobil.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malfin.crud.mobil.entity.DetailMobil;
import com.malfin.crud.mobil.repo.DetailMobilRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DetailMobilService {

  @Autowired
  private DetailMobilRepo detailmobilRepo;

  public Iterable<DetailMobil> findAll() {
    return detailmobilRepo.findAll();
  }

  public void addDetailMobil(DetailMobil detailmobil) {
    detailmobilRepo.save(detailmobil);
  }

  public boolean existsById(Integer id) {
    return detailmobilRepo.existsById(id);
  }

  public void deleteById(int id) {
    detailmobilRepo.deleteById(id);
  }

  public Optional<DetailMobil> findById(int id) {
    return detailmobilRepo.findById(id);
  }

  public List<DetailMobil> findByMobilId(int id_mobil) {
    return detailmobilRepo.findByMobilId(id_mobil);
  }

  public List<DetailMobil> findByWarnaId(int id_warna) {
    return detailmobilRepo.findByWarnaId(id_warna);
  }

  public void updateDetailMobil(DetailMobil detailmobil) {
    detailmobilRepo.save(detailmobil);
  }
}
