package com.malfin.crud.mobil.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MobilAdapter {

  private Mobil mobil; // Ini adalah cara memanggil model lain
  private DetailMobil detailMobil;
  private int idWarna;
  private int idMobil;
  private int idDetail;
  private String tipeWarna;
  private String deskripsi;
  private List<DetailMobil> detailMobils = new ArrayList<>();
  private List<Warna> warnas;
  private List<MobilAdapter> detailMobilAdapters = new ArrayList<>();

  // private List<Integer> idWarnas = new ArrayList<Integer>(); // Cara memanggil list di model lain
  // private List<String> tipeWarnas = new ArrayList<String>();

  public MobilAdapter() {}

  public MobilAdapter(Mobil mobil) {
    this.mobil = mobil;
  }

  public MobilAdapter(Mobil mobil, List<DetailMobil> detailMobils) {
    this.mobil = mobil;
    this.detailMobils = detailMobils;
  }
  // public MobilAdapter(Mobil mobil, DetailMobil detailmobil)
  // {
  //     this.mobil = mobil;
  //     this.detailmobil = detailmobil;
  // }

}
