package com.example.ssilueta.entidades;

import java.io.Serializable;

public class Datos implements Serializable {
    private Integer idUsuario;// id_MAscota
    private Integer idIdent;// id_duenio
    private float imc;//nombre mascota
    private float porGrasa;//raza mascota
    private float kgMusculo;

    public Datos(){

    }


    public Datos(Integer idUsuario, Integer idIdent, float imc, float porGrasa, float kgMusculo) {
        this.idUsuario = idUsuario;
        this.idIdent = idIdent;
        this.imc = imc;
        this.porGrasa = porGrasa;
        this.kgMusculo = kgMusculo;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdIdent() {
        return idIdent;
    }

    public void setIdIdent(Integer idIdent) {
        this.idIdent = idIdent;
    }

    public float getImc() {
        return imc;
    }

    public void setImc(float imc) {
        this.imc = imc;
    }

    public float getPorGrasa() {
        return porGrasa;
    }

    public void setPorGrasa(float porGrasa) {
        this.porGrasa = porGrasa;
    }

    public float getKgMusculo() {
        return kgMusculo;
    }

    public void setKgMusculo(float kgMusculo) {
        this.kgMusculo = kgMusculo;
    }
}

