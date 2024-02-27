package com.malfin.crud.mobil.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Entity
@Table(name ="warna")

public class Warna {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="nama_warna", length=100, nullable = false)
    private String namaWarna;

    public Warna(){
    }

    @OneToMany(mappedBy= "warna", cascade = CascadeType.ALL)
    private List<DetailMobil> detailmobils;

    }
