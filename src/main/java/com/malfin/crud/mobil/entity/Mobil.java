package com.malfin.crud.mobil.entity;

import java.math.BigInteger;
import java.util.ArrayList;
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
@Table(name ="mobil")
public class Mobil {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="merek", length=25, nullable = false)
    private String merek;

    @Column(length=25, nullable = false)
    private String model;

    @Column(name="tahun_produksi",length=4, nullable = false)
    private String tahunProduksi;

    @Column(name="jumlah_pintu",length=1, nullable = false)
    private char jumlahPintu;

    @Column(length=10, nullable = false)
    private BigInteger harga;

    public Mobil(){
    }

    @OneToMany(mappedBy = "mobil", cascade = CascadeType.ALL)
    private List<Sedan> sedans;

    @OneToMany(mappedBy = "mobil", cascade = CascadeType.ALL)
    private List<Porsche> porsches;

    @OneToMany(mappedBy = "mobil", cascade = CascadeType.ALL)
    private List<DetailMobil> detailmobils = new ArrayList<DetailMobil>();

    }


