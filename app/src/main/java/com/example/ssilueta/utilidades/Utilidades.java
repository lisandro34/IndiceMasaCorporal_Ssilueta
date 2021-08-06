package com.example.ssilueta.utilidades;

public class Utilidades {
    //constantes campos  tabla de usuario
    public static final String TABLA_USUARIO = "usuario";// campo
    public static final String CAMPO_DOCUMENTO = "documento";
    public static final String CAMPO_NOMBRE = "nombre";
    public static final String CAMPO_TELEFONO = "telefono";


    public static final String CREAR_TABLA_USUARIO = "CREATE TABLE " +TABLA_USUARIO+" (" +CAMPO_DOCUMENTO+ " " +"INTEGER, "+CAMPO_NOMBRE+ " TEXT, " +CAMPO_TELEFONO+" TEXT)"; // bd con sus campos

    //constantes campos  tabla datos
    public static final String TABLA_DATOS = "datos";
    public static final String CAMPO_ID_USUARIO = "idUsuario";// campo_id_mascota =id_MAscota
    public static final String CAMPO_IMC = "imc";//nombre mascota
    public static final String CAMPO_PORGRASA = "porGrasa";// razamascota
    public static final String CAMPO_KGMUSCULO = "kgMusculo";
    public static final String CAMPO_ID_IDENT = "idIdent";// campo_id_duenio = id_duenio

    public static final String CREAR_TABLA_DATOS = "CREATE TABLE " + TABLA_DATOS + " (" +CAMPO_ID_USUARIO+" INTEGER PRIMARY KEY AUTOINCREMENT, " + CAMPO_IMC + " TEXT," + CAMPO_PORGRASA + " TEXT," + CAMPO_KGMUSCULO + " TEXT, "+CAMPO_ID_IDENT+ " INTEGER)";


}

