package com.malfin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malfin.entity.Warna;
import com.malfin.repo.WarnaRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class WarnaService {
    @Autowired
    private WarnaRepo repo;
    
    public Iterable<Warna> findAll(){
        return repo.findAll();
    }

    public void addWarna(Warna warna)
    {
       repo.save(warna);
    }

    public void deleteById(int id)
    {
      repo.deleteById(id);
    }

    public Optional<Warna> findById(int id)
    {
        return repo.findById(id);
    }

    public void updateSedan(Warna warna)
    {
        repo.save(warna);
    }
}
