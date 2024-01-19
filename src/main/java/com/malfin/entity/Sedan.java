package com.malfin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name ="sedan")
public class Sedan {
    @Id 
    private int id;

    @ManyToOne
    @JoinColumn(name="id_mobil", nullable = false)
    private Mobil mobil;

    @Column(length=25, nullable = false)
    private String jumlah_penumpang;

    @Column(length=4, nullable = false)
    private String fitur_tambahan;

    public Sedan(){
    }

        public void setId(int id)
        {
            this.id = id;
        }

        public int getId()
        {
            return this.id;
        }

        public void setMobil(Mobil mobil)
        {
            this.mobil = mobil;
        }

        public Mobil getMobil()
        {
            return this.mobil;
        }

        public void setJumlah_penumpang(String jumlah_penumpang)
        {
            this.jumlah_penumpang = jumlah_penumpang;
        }

        public String getJumlah_penumpang()
        {
            return this.jumlah_penumpang;
        }

        public void setFitur_tambahan(String fitur_tambahan)
        {
            this.fitur_tambahan = fitur_tambahan;
        }

        public String getFitur_tambahan()
        {
            return this.fitur_tambahan;
        }

    }
