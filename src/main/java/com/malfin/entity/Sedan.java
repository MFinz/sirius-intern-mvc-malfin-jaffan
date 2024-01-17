package com.malfin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="sedan")
public class Sedan {
    @Id 
    private int id;

    @Column(length=25, nullable = false)
    private int id_mobil;

    @Column(length=25, nullable = false)
    private String jumlah_penumpang;

    @Column(length=4, nullable = false)
    private String fitur_tambahan;

    public Sedan(){
    }

        public int getId()
        {
            return this.id;
        }

        public void setId(int id)
        {
            this.id = id;
        }

        public int getId_mobil()
        {
            return this.id_mobil;
        }

        public void setId_mobil(int id_mobil)
        {
            this.id_mobil = id_mobil;
        }

        public String getJumlah_penumpang()
        {
            return this.jumlah_penumpang;
        }

        public void setJumlah_penumpang(String jumlah_penumpang)
        {
            this.jumlah_penumpang = jumlah_penumpang;
        }

        public String getFitur_tambahan()
        {
            return this.fitur_tambahan;
        }

        public void setFitur_tambahan(String fitur_tambahan)
        {
            this.fitur_tambahan = fitur_tambahan;
        }

    }
