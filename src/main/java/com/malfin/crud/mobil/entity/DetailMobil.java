package com.malfin.crud.mobil.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name ="detail_mobil")

public class DetailMobil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="tipe_warna", length=100, nullable = false)
    private String tipeWarna;

    @Column(name="deskripsi", length=100, nullable = false)
    private String deskripsi;

    public DetailMobil(){
    }
        
        @ManyToOne
        @JoinColumn(name="id_mobil", nullable = false)
        private Mobil mobil;
    
        @ManyToOne
        @JoinColumn(name="id_warna", nullable = false)
        private Warna warna;
        
    }


