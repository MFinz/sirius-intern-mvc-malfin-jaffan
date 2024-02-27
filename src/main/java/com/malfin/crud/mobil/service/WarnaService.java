package com.malfin.crud.mobil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malfin.crud.mobil.entity.Warna;
import com.malfin.crud.mobil.repo.WarnaRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class WarnaService {

  @Autowired
  private WarnaRepo warnaRepo;

  public List<Warna> findAll() {
    return warnaRepo.findAll();
  }

  public void addWarna(Warna warna) {
    warnaRepo.save(warna);
  }

  // Cek Nama Warna (Create)
  public boolean existsBynamaWarna(String namaWarna) {
    return warnaRepo.existsBynamaWarna(namaWarna);
  }

  // Cek Nama Warna (Update)
  public boolean existsById(Integer id) {
    return warnaRepo.existsById(id);
  }

  public void deleteById(int id) {
    warnaRepo.deleteById(id);
  }

  public Warna findById(int id) {
    return warnaRepo.getReferenceById(id);
  }

  public void updateWarna(Warna warna) {
    warnaRepo.save(warna);
  }
}
