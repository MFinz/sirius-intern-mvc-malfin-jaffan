package com.malfin.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.malfin.entity.DetailMobil;

public interface DetailMobilRepo extends JpaRepository<DetailMobil, Integer> {
    List<DetailMobil> findByMobilId(Integer id_mobil);
}

