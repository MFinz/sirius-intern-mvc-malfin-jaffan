package com.malfin.crud.mobil.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malfin.crud.mobil.entity.Mobil;
import com.malfin.crud.mobil.entity.Porsche;
import com.malfin.crud.mobil.repo.PorscheRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PorscheService {

  @Autowired
  private PorscheRepo porscheRepo;

  public List<Porsche> findAll() {
    return porscheRepo.findAll();
  }

  public void addPorsche(Porsche porsche) {
    porscheRepo.save(porsche);
  }

  public boolean existsByMobil(Mobil mobil) {
    return porscheRepo.existsByMobil(mobil);
  }

  public boolean existsById(Integer id) {
    return porscheRepo.existsById(id);
  }

  public void deleteById(int id) {
    porscheRepo.deleteById(id);
  }

  public Porsche findById(int id) {
    return porscheRepo.getReferenceById(id);
  }

  public void updatePorsche(Porsche porsche) {
    porscheRepo.save(porsche);
  }
}
