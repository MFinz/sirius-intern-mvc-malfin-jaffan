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
@Table(name ="sedan")
public class Sedan {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="id_mobil", nullable = false)
    private Mobil mobil;

    @Column(name="jumlah_penumpang",length=25, nullable = false)
    private String jumlahPenumpang;

    @Column(name="fitur_tambahan",length=4, nullable = false)
    private String fiturTambahan;

    }
