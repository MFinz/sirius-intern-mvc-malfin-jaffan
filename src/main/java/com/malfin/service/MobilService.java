package com.malfin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malfin.entity.Mobil;
import com.malfin.repo.MobilRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class MobilService {
    @Autowired
    private MobilRepo repo;
    
    public Iterable<Mobil> findAll(){
        return repo.findAll();
    }

    public void addMobil(Mobil mobil)
    {
       repo.save(mobil);
    }

    public void deleteById(int id)
    {
      repo.deleteById(id);
    }

    public Optional<Mobil> findById(int id)
    {
        return repo.findById(id);
    }

    public void updateMobil(Mobil mobil)
    {
        repo.save(mobil);
    }
}
