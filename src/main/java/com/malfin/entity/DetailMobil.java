package com.malfin.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="detail_mobil")

public class DetailMobil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public DetailMobil(){
    }
        
        @ManyToOne
        @JoinColumn(name="id_mobil", nullable = false)
        private Mobil mobil;
    
        @ManyToOne
        @JoinColumn(name="id_warna", nullable = false)
        private Warna warna;

        public Integer getId() {
            return id;
        }
    
        public void setId(Integer id) {
            this.id = id;
        }
    
        public Mobil getMobil() {
            return mobil;
        }
    
        public void setMobil(Mobil id_mobil) {
            this.mobil = id_mobil;
        }
    
        public Warna getWarna() {
            return warna;
        }
    
        public void setWarna(Warna id_warna) {
            this.warna = id_warna;
        }
    }


