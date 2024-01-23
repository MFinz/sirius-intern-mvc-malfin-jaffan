package com.malfin.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="warna")

public class Warna {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length=100, nullable = false)
    private String warna;

    public Warna(){
    }

    @OneToMany(mappedBy= "warna", cascade = CascadeType.ALL)
    private List<DetailMobil> detailmobils;

        public List<DetailMobil> getDetailmobils() {
            return detailmobils;
        }

        public void setDetailmobils(List<DetailMobil> detailmobils) {
            this.detailmobils = detailmobils;
        }

        public int getId() 
        {
            return this.id;
        }
    
        public void setId(int id) 
        {
            this.id = id;
        }
    
        public String getWarna() 
        {
            return warna;
        }
    
        public void setWarna(String warna) 
        {
            this.warna = warna;
        }
        
    }
