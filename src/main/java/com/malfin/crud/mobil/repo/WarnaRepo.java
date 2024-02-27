package com.malfin.crud.mobil.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malfin.crud.mobil.entity.Warna;

@Repository
public interface WarnaRepo extends JpaRepository<Warna, Integer> {
  boolean existsBynamaWarna(String namaWarna);

  @Override
  boolean existsById(Integer id);
}
