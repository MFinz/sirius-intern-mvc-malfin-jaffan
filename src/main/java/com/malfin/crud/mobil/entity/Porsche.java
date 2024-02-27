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
@Table(name ="porsche")
public class Porsche {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="id_mobil", nullable = false)
    private Mobil mobil;

    @Column(name="kecepatan_maksimal",length=3, nullable = false)
    private int kecepatanMaksimal;

    @Column(name="tipe_mesin",length=5, nullable = false)
    private String tipeMesin;

    public Porsche(){
    }

}
