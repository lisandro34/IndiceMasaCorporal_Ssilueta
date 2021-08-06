package com.example.ssilueta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ssilueta.entidades.Usuario;
import com.example.ssilueta.entidades.Datos;
import com.example.ssilueta.utilidades.Utilidades;

import java.util.ArrayList;

public class ConsultaLista extends AppCompatActivity {

    ListView listViewConsulta;
    ArrayList<String> listaInformacion;
    ArrayList<Usuario> listaUsuario;// lista mascota

    ConexionSQLiteHelper conn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta_lista);

        conn= new ConexionSQLiteHelper(this, "bd_usuarios", null,1);

        listViewConsulta =(ListView)findViewById(R.id.listViewConsulta);

       consultarListaPersonas();

        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_list_item_1,listaInformacion); //muestra lista
        listViewConsulta.setAdapter(adaptador);

        listViewConsulta.setOnItemClickListener(new AdapterView.OnItemClickListener() { //metodo para ver info en el toast

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                /*String informacion="Documento: "+ listaUsuario.get(position).getDocumento()+"\n";
                informacion+="Nombre: " + listaUsuario.get(position).getNombre()+"\n";
                informacion+="Telefono: "+ listaUsuario.get(position).getTelefono()+"\n";*/


                //Toast.makeText(getApplicationContext(), informacion,Toast.LENGTH_LONG).show();

                Usuario user= listaUsuario.get(position);

                Intent intent = new Intent(ConsultaLista.this,DetalleUsuario.class);

                Bundle bundle = new Bundle();
                bundle.putSerializable("usuario", user);

                intent.putExtras(bundle);
                startActivity(intent);

            }

        });

    }

    private void consultarListaPersonas() {
        SQLiteDatabase db = conn.getReadableDatabase();

       Usuario usuario= null;
        listaUsuario = new ArrayList<Usuario>();

        //select * from tabla datos, tabla usuarios
        Cursor cursor = db.rawQuery("SELECT * FROM " + Utilidades.TABLA_USUARIO, null);

        while (cursor.moveToNext()){
            usuario = new Usuario();
            usuario.setDocumento(cursor.getInt(0));
            usuario.setNombre(cursor.getString(1));
            usuario.setTelefono(cursor.getString(2));

            listaUsuario.add(usuario);
        }
        obtenerLista();
    }

    private void obtenerLista() {
        listaInformacion = new ArrayList<String>();
        for (int i=0; i <listaUsuario.size(); i++){
            listaInformacion.add(listaUsuario.get(i).getDocumento()+ " - "+listaUsuario.get(i).getNombre());
        }
    }
}