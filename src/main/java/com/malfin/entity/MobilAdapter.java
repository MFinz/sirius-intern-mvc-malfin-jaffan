package com.malfin.entity;

import java.util.List;

public class MobilAdapter {
    
    private Mobil mobil; // Ini adalah cara memanggil model lain
    private List<DetailMobil> detailMobils; // Cara memanggil list di model lain
    
    public MobilAdapter(Mobil mobil, List<DetailMobil> detailMobils){
        this.mobil = mobil;
        this.detailMobils = detailMobils;
    }

    public Mobil getMobil() {
        return mobil;
    }

    public void setMobil(Mobil mobil) {
        this.mobil = mobil;
    }

    public List<DetailMobil> getDetailmobils() {
        return detailMobils;
    }

    public void setDetailmobils(List<DetailMobil> detailmobils) {
        this.detailMobils = detailmobils;
    }
}
