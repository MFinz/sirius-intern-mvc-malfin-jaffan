package com.malfin.crud.mobil.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malfin.crud.mobil.entity.Mobil;
import com.malfin.crud.mobil.entity.Porsche;

@Repository
public interface PorscheRepo extends JpaRepository<Porsche, Integer> {
  @Override
  boolean existsById(Integer id);

  boolean existsByMobil(Mobil mobil);
}
