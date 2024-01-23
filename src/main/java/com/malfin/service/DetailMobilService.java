package com.malfin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.malfin.entity.DetailMobil;
import com.malfin.repo.DetailMobilRepo;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class DetailMobilService {
    @Autowired
    private DetailMobilRepo repo;
    
    public Iterable<DetailMobil> findAll(){
        return repo.findAll();
    }

    public void addDetailMobil(DetailMobil detailmobil)
    {
       repo.save(detailmobil);
    }

    public void deleteById(int id)
    {
      repo.deleteById(id);
    }

    public Optional<DetailMobil> findById(int id)
    {
        return repo.findById(id);
    }

    public List<DetailMobil> findByMobilId(int id_mobil)
    {
        return repo.findByMobilId(id_mobil);
    }

    public void updateDetailMobil(DetailMobil detailmobil)
    {
        repo.save(detailmobil);
    }
}
