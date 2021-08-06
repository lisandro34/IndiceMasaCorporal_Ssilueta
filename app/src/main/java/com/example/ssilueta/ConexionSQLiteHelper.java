package com.example.ssilueta;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.ssilueta.utilidades.Utilidades;

public class ConexionSQLiteHelper extends SQLiteOpenHelper { //constructor



    public ConexionSQLiteHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);// crea la bd
    }

    @Override
    public void onCreate(SQLiteDatabase db) {//se crea la tabla
        db.execSQL(Utilidades.CREAR_TABLA_USUARIO);
        db.execSQL(Utilidades.CREAR_TABLA_DATOS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {//actualiza la bd
        db.execSQL("DROP TABLE IF EXISTS " +Utilidades.TABLA_USUARIO);
        db.execSQL("DROP TABLE IF EXISTS " +Utilidades.TABLA_DATOS);
       onCreate(db);

    }

}

