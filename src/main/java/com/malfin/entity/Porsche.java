package com.malfin.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name ="porsche")
public class Porsche {
     @Id 
    private int id;

    @Column(length=25, nullable = false)
    private int id_mobil;

    @Column(length=3, nullable = false)
    private int kecepatan_maksimal;

    @Column(length=5, nullable = false)
    private String tipe_mesin;

    public Porsche(){
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

        public int getKecepatan_maksimal()
        {
            return this.kecepatan_maksimal;
        }

        public void setKecepatan_maksimal(int kecepatan_maksimal)
        {
            this.kecepatan_maksimal =kecepatan_maksimal;
        }

        public String getTipe_mesin()
        {
            return this.tipe_mesin;
        }

        public void setTipe_mesin(String tipe_mesin)
        {
            this.tipe_mesin = tipe_mesin;
        }
}
