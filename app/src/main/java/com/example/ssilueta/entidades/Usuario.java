package com.example.ssilueta.entidades;

import java.io.Serializable;

public class Usuario implements Serializable {// campos de la tabla de la bd
    private Integer documento;
    private String nombre;
    private String telefono;


    public Usuario(Integer documento, String nombre, String telefono) {
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public Usuario(){

    }

    public Integer getDocumento() {
        return documento;
    }

    public void setDocumento(Integer documento) {
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}