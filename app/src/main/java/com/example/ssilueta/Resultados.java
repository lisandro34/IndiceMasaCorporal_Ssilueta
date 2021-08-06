package com.example.ssilueta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ssilueta.utilidades.Utilidades;

import java.security.KeyStore;
import java.text.DecimalFormat;

public class Resultados extends AppCompatActivity {
    private EditText et_imc;
    private EditText et_calorias;
    private EditText et_kgGrasa;
    private EditText et_kgMusculo;
    private EditText et_proteinadia;
    private EditText et_porGrasa;
    private EditText et_pmejerci;
    private EditText et_pmtres;
    private EditText et_pmseis;
    private EditText et_pbejerci;
    private EditText et_pbtres;
    private EditText et_pbseis;
    private TextView tv_id;
    private Button btnLineChart;
    private TextView tv;

    private  float kgGrasa, diaProteina, calorias,
            pmejercicio, pmtresdias, pmseisdias, pbejercicio, pbseisdias,pbtresdias;

    public static float porGrasa, kgMusculo, imc, imc2;

    String string_imc, string_kgGrasa, string_kgMusculo, string_Proteinadia, string_porGrasa, string_calorias,
            string_pmejercicio, string_tres_dias, string_seis_dias, string_pbejercicio, nombre;

    ConexionSQLiteHelper conn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);
        et_imc = (EditText)findViewById(R.id.editText_imc);
        et_calorias = (EditText)findViewById(R.id.editText_calorias);
        et_kgGrasa = (EditText)findViewById(R.id.editText_kgGrasa);
        et_kgMusculo = (EditText)findViewById(R.id.editText_kgMusculo);
        et_proteinadia = (EditText)findViewById(R.id.editText_proteina);
        et_porGrasa = (EditText)findViewById(R.id.editText_porGrasa);
        et_pmejerci = (EditText)findViewById(R.id.editText_pmejerci);
        et_pmtres = (EditText)findViewById(R.id.editText_pmtres);
        et_pmseis = (EditText)findViewById(R.id.editText_pmseis);
        et_pbejerci = (EditText)findViewById(R.id.editText_pbejerci);
        et_pbseis = (EditText)findViewById(R.id.editText_pbseis);
        et_pbtres = (EditText)findViewById(R.id.editText_pbtres);
        btnLineChart = (Button) findViewById(R.id.button_regresar);
        tv = (TextView)findViewById(R.id.textView_nombre);

         conn= new ConexionSQLiteHelper(this, "bd_usuarios", null,1); //instancia para  conexion



        // metodo para decimales
        DecimalFormat formato2 = new DecimalFormat("#.##");


// se recuperan los datos de la activity de datos
        nombre = getIntent().getStringExtra("nombre");
        tv.setText(nombre);

        string_calorias = getIntent().getStringExtra("calorias");
        calorias = Float.parseFloat(string_calorias);// se cambia el valor de string a entero
        et_calorias.setText(String.valueOf(calorias));

        string_imc = getIntent().getStringExtra("imc");
        imc = Float.parseFloat(string_imc);// se cambia el valor de string a entero
        et_imc.setText(String.valueOf(formato2.format(imc)));

        string_porGrasa = getIntent().getStringExtra("porGrasa");
        porGrasa = Float.parseFloat(string_porGrasa);// se cambia el valor de string a entero
        et_porGrasa.setText(String.valueOf(formato2.format(porGrasa)));

        string_kgGrasa = getIntent().getStringExtra("kgGrasa");
        kgGrasa = Float.parseFloat(string_kgGrasa);// se cambia el valor de string a entero
        et_kgGrasa.setText(String.valueOf(formato2.format(kgGrasa)));

        string_kgMusculo = getIntent().getStringExtra("kgMusculo");
        kgMusculo = Float.parseFloat(string_kgMusculo);// se cambia el valor de string a entero
        et_kgMusculo.setText(String.valueOf(formato2.format(kgMusculo)));

        string_Proteinadia = getIntent().getStringExtra("diaProteina");
        diaProteina = Float.parseFloat(string_Proteinadia);// se cambia el valor de string a entero
        et_proteinadia.setText(String.valueOf(formato2.format(diaProteina)));

        //para mantener
        string_pmejercicio = getIntent().getStringExtra("pmejercicio");
        pmejercicio = Float.parseFloat(string_pmejercicio);// se cambia el valor de string a entero
        et_pmejerci.setText(String.valueOf(formato2.format(pmejercicio)));

        string_tres_dias = getIntent().getStringExtra("pmtresdias");
        pmtresdias = Float.parseFloat(string_tres_dias);// se cambia el valor de string a entero
        et_pmtres.setText(String.valueOf(formato2.format(pmtresdias)));

        string_seis_dias = getIntent().getStringExtra("pmseisdias");
        pmseisdias = Float.parseFloat(string_seis_dias);// se cambia el valor de string a entero
        et_pmseis.setText(String.valueOf(formato2.format(pmseisdias)));

        //para bajar
        string_pbejercicio = getIntent().getStringExtra("pbejercicio");
        pbejercicio = Float.parseFloat(string_pbejercicio);// se cambia el valor de string a entero
        et_pbejerci.setText(String.valueOf(formato2.format(pbejercicio)));

        string_tres_dias = getIntent().getStringExtra("pbtresdias");
        pbtresdias = Float.parseFloat(string_tres_dias);// se cambia el valor de string a entero
        et_pbtres.setText(String.valueOf(formato2.format(pbtresdias)));

        string_seis_dias = getIntent().getStringExtra("pbseisdias");
        pbseisdias = Float.parseFloat(string_seis_dias);// se cambia el valor de string a entero
        et_pbseis.setText(String.valueOf(formato2.format(pbseisdias)));

    }
    //Metodo para el boton graficar
    public void Graficar_Chart(View view) {

       registrarDatos();

        Intent grafico_chart = new Intent(this, Grafica.class);


       string_porGrasa = String.valueOf(porGrasa);
        grafico_chart.putExtra("porGrasa", string_porGrasa);
        startActivity(grafico_chart);


        string_imc = String.valueOf(imc);
        grafico_chart.putExtra("imc", string_imc);
        startActivity(grafico_chart);


        string_kgMusculo = String.valueOf(kgMusculo);
        grafico_chart.putExtra("kgMusculo", string_kgMusculo);
        startActivity(grafico_chart);
        finish();

    }
    private void registrarDatos() {


        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values= new ContentValues();

        values.put(Utilidades.CAMPO_IMC, et_imc.getText().toString());
        values.put(Utilidades.CAMPO_PORGRASA, et_kgGrasa.getText().toString());
        values.put(Utilidades.CAMPO_KGMUSCULO, et_kgMusculo.getText().toString());



        //introducir los campos en la bd

        Long documentoResultante = db.insert(Utilidades.TABLA_DATOS, Utilidades.CAMPO_IMC, values);

        Toast.makeText(getApplicationContext(), "Datos Registrados:" +documentoResultante, Toast.LENGTH_SHORT).show();
        db.close();

    }


}