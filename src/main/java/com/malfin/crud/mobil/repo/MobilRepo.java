package com.malfin.crud.mobil.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.malfin.crud.mobil.entity.Mobil;

@Repository
public interface MobilRepo extends JpaRepository<Mobil, Integer>{
}
