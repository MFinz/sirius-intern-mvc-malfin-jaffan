package com.malfin.crud.mobil.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.malfin.crud.mobil.entity.DetailMobil;

@Repository
public interface DetailMobilRepo extends JpaRepository<DetailMobil, Integer> {
  List<DetailMobil> findByMobilId(Integer id_mobil);
  List<DetailMobil> findByWarnaId(Integer id_warna);
  boolean existsByMobilIdAndWarnaId(Integer id_mobil, Integer id_warna);

  @Override
  boolean existsById(Integer id);

  @Query("SELECT MAX(id) FROM DetailMobil")
  Integer getMaxId();
}
