package com.malfin.crud.mobil.repo;

import com.malfin.crud.mobil.entity.Mobil;
import com.malfin.crud.mobil.entity.Sedan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SedanRepo extends JpaRepository<Sedan, Integer> {
  @Override
  boolean existsById(Integer id);

  boolean existsByMobil(Mobil mobil);
}
