package com.example.ssilueta;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ssilueta.utilidades.Utilidades;

public class ConsultarUsuario extends AppCompatActivity {

    EditText campoId, campoNombre, campoTelefono, campoImc, campoporGrasa, campoKgMusculo;

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_usuario);

        conn = new ConexionSQLiteHelper(getApplicationContext(), "bd_usuarios", null,1);

        campoId = (EditText)findViewById(R.id.documentoId);
        campoNombre = (EditText)findViewById(R.id.campoNombreConsulta);
        campoTelefono = (EditText)findViewById(R.id.campoTelefonoConsulta);
        campoImc = (EditText)findViewById(R.id.consultaImc);
        campoporGrasa = (EditText)findViewById(R.id.consultaGrasa);
        campoKgMusculo = (EditText)findViewById(R.id.consultaKgmusculo);
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnConsultar:
                consultar();
            break;
            case R.id.btnActualizar:
            break;
            case R.id.btnEliminar:
            break;
        }
    }

    private void consultar(){
        SQLiteDatabase db = conn.getReadableDatabase();
        String [] parametros = {campoId.getText().toString(), campoImc.getText().toString()};//para generar la consulta por el documento
        //campos que nos va devolver la consulta
        String[] campos = {Utilidades.CAMPO_NOMBRE, Utilidades.CAMPO_TELEFONO, Utilidades.CAMPO_IMC, Utilidades.CAMPO_PORGRASA, Utilidades.CAMPO_KGMUSCULO};//campos que queremos que se visualizaran



        //estructura para enviar la inf a consultar a la bd

        try{
           // Cursor cursor = db.rawQuery("SELECT * FROM "+ Utilidades.TABLA_USUARIO+ Utilidades.TABLA_DATOS, null);
            //Cursor cursor = db.rawQuery("SELECT  *  FROM " + Utilidades.TABLA_USUARIO +" ," + Utilidades.TABLA_DATOS + " WHERE " + Utilidades.CAMPO_DOCUMENTO+ " =? " , parametros);

            Cursor cursor= db.query(Utilidades.TABLA_USUARIO + Utilidades.TABLA_DATOS,campos,Utilidades.CAMPO_DOCUMENTO+" =? ",parametros,null,null,null);
            cursor.moveToFirst();
            campoNombre.setText(cursor.getString(0));
            campoTelefono.setText(cursor.getString(1));

            campoImc.setText(cursor.getString(0));
            campoporGrasa.setText(cursor.getString(1));
            campoKgMusculo.setText(cursor.getString(2));



            cursor.close();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "El documento no existe", Toast.LENGTH_LONG).show();
            limpiar();

        }
    }

    private void limpiar() {
        campoNombre.setText("");
        campoTelefono.setText("");


    }
}