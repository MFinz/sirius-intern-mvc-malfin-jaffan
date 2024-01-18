package com.malfin.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malfin.entity.Porsche;
import com.malfin.repo.PorscheRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class PorscheService {
     @Autowired
    private PorscheRepo repo;
    
    public Iterable<Porsche> findAll(){
        return repo.findAll();
    }

    public void addPorsche(Porsche porsche)
    {
       repo.save(porsche);
    }

    public void deleteById(int id)
    {
      repo.deleteById(id);
    }

    public Optional<Porsche> findById(int id)
    {
        return repo.findById(id);
    }

    public void updatePorsche(Porsche porsche)
    {
        repo.save(porsche);
    }
}
