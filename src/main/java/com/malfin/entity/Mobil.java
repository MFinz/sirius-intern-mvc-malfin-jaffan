package com.malfin.entity;

import java.math.BigInteger;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name ="mobil")
public class Mobil {
    @Id 
    private int id;

    @Column(length=25, nullable = false)
    private String merek;

    @Column(length=25, nullable = false)
    private String model;

    @Column(length=4, nullable = false)
    private String tahun_produksi;

    @Column(length=25, nullable = false)
    private String warna;

    @Column(length=1, nullable = false)
    private char jumlah_pintu;

    @Column(length=10, nullable = false)
    private BigInteger harga;

   

    public Mobil(){
    }

    @OneToMany(mappedBy = "mobil", cascade = CascadeType.ALL)
    private List<Sedan> sedans;

    @OneToMany(mappedBy = "mobil", cascade = CascadeType.ALL)
    private List<Porsche> porsches;

        public int getId()
        {
            return this.id;
        }

        public void setId(int id)
        {
            this.id = id;
        }

        public String getMerek()
        {
            return this.merek;
        }

        public void setMerek(String merek)
        {
            this.merek = merek;
        }

        public String getModel()
        {
            return this.model;
        }

        public void setModel(String model)
        {
            this.model = model;
        }

        public String getTahun_produksi()
        {
            return this.tahun_produksi;
        }

        public void setTahun_produksi(String tahun_produksi)
        {
            this.tahun_produksi = tahun_produksi;
        }

        public String getWarna()
        {
            return this.warna;
        }

        public void setWarna(String warna)
        {
            this.warna = warna;
        }

        public char getJumlah_pintu()
        {
            return this.jumlah_pintu;
        }

        public void setJumlah_pintu(char jumlah_pintu)
        {
            this.jumlah_pintu = jumlah_pintu;
        }

        public BigInteger getHarga()
        {
            return this.harga;
        }

        public void setHarga(BigInteger harga)
        {
            this.harga = harga;
        }

       
    }


