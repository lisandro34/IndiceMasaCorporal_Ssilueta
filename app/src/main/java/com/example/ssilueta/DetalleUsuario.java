package com.example.ssilueta;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ssilueta.entidades.Usuario;
import com.example.ssilueta.entidades.Datos;
import com.example.ssilueta.utilidades.Utilidades;

public class DetalleUsuario extends AppCompatActivity {

    ConexionSQLiteHelper conn;

    TextView campoDocumento, campoNombre, campoTelefono;
    TextView campoImc, campoPorGrasa, campoKgMusculo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_usuario);

        campoDocumento = (TextView) findViewById(R.id.campoDocumento);
        campoNombre = (TextView) findViewById(R.id.campoNombre);
        campoTelefono = (TextView) findViewById(R.id.campoTelefono);

        campoImc = (TextView) findViewById(R.id.campoIMC);
        campoPorGrasa = (TextView) findViewById(R.id.campoPorGrasa);
        campoKgMusculo = (TextView) findViewById(R.id.campoKgMusculo);


       Bundle objetoEnviado = getIntent().getExtras();
        Usuario user = null;

        if (objetoEnviado != null) {
            user = (Usuario) objetoEnviado.getSerializable("usuario");

            campoDocumento.setText(user.getDocumento().toString());
            campoNombre.setText(user.getNombre().toString());
            campoTelefono.setText(user.getTelefono().toString());
           //consultarPersonas(user.getDocumento());

        }
    }

    private void consultarPersonas(Integer idPersona){
        SQLiteDatabase db= conn.getReadableDatabase();

        String[] parametros={idPersona.toString()};
        String[] campos={Utilidades.CAMPO_IMC,Utilidades.CAMPO_PORGRASA};
        Toast.makeText(getApplicationContext(),"El documento " +idPersona, Toast.LENGTH_LONG).show();

        try{
            Cursor cursor = db.query(Utilidades.TABLA_DATOS,campos, Utilidades.CAMPO_ID_USUARIO+"=?",parametros,null,null,null);
            cursor.moveToFirst();
            campoImc.setText(idPersona.toString());
            campoPorGrasa.setText(cursor.getString(0));
            //campoKgMusculo.setText(cursor.getString(1));
            cursor.close();

        }catch (Exception e){
            Toast.makeText(getApplicationContext(), "El documento no existe", Toast.LENGTH_LONG).show();
            campoImc.setText("");
            campoPorGrasa.setText("");

        }
    }
}