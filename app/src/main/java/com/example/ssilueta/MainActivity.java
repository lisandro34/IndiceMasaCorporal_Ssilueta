package com.example.ssilueta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ssilueta.utilidades.Utilidades;

public class MainActivity extends AppCompatActivity {
    private EditText campoNombre;
    private EditText campoDocumento;
    private EditText campoTelefono;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoNombre = (EditText)findViewById(R.id.campoNombre);
        campoDocumento = (EditText)findViewById(R.id.documentoId);
        campoTelefono = (EditText)findViewById(R.id.campoTelefono);



    }
    public void Nombre(View view){
        registrarUsuarios();

        String nombre = campoNombre.getText().toString();

        Intent intent = new Intent(this, Datos.class);
        intent.putExtra("nombre", nombre);
        startActivity(intent);
        finish();

    }

    private void registrarUsuarios() {

        ConexionSQLiteHelper conn= new ConexionSQLiteHelper(this, "bd_usuarios", null,1); //instancia para  conexion

        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values= new ContentValues();
        values.put(Utilidades.CAMPO_DOCUMENTO, campoDocumento.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE, campoNombre.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO, campoTelefono.getText().toString());



        //introducir los campos en la bd

        long documentoResultante = db.insert(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_DOCUMENTO, values);

        Toast.makeText(getApplicationContext(), "Documento Registrar:" +documentoResultante, Toast.LENGTH_SHORT).show();


    }
    public void Consultarm(View view){

        //String nombre = campoNombre.getText().toString();

        Intent intent = new Intent(this, ConsultaLista.class);
        startActivity(intent);
        finish();

    }
}