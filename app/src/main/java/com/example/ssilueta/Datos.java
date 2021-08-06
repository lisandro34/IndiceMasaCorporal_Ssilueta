package com.example.ssilueta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ssilueta.utilidades.Utilidades;

public class Datos extends AppCompatActivity {
    private EditText et_edad;
    private EditText et_altura;
    private EditText et_peso;
    private EditText et_cuello;
    private EditText et_cadera;
    private EditText et_cintura;
    private RadioButton rbt_Hombre;
    private RadioButton rbt_Mujer;
    private RadioGroup rg;
    private TextView tv;

    private  float   porGrasa, kgMusculo, imc, kgGrasa,  diaProteina, calorias, numero, denominador,
            preGrasa, pm_ejercicio, tres_dias, seis_dias, pb_ejercicio, pb_tresdias, pb_seisdias;




    String string_imc, string_kgGrasa, string_kgMusculo, string_diaProteina,string_calorias, string_porGrasa,
            string_pmejercicio, string_tres_dias, string_seis_dias, string_pbejercicio, nombre;
    private  double raiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        et_edad = (EditText)findViewById(R.id.editText_edad);
        et_altura = (EditText)findViewById(R.id.editText_altura);
        et_peso = (EditText)findViewById(R.id.editText_peso);
        et_cuello = (EditText)findViewById(R.id.editText_cuello);
        et_cadera = (EditText)findViewById(R.id.editText_cadera);
        et_cintura = (EditText)findViewById(R.id.editText_cintura);
        rbt_Hombre = (RadioButton)findViewById(R.id.rbt_Hombre);
        rbt_Mujer = (RadioButton)findViewById(R.id.rbt_Mujer);
        rg = (RadioGroup)findViewById(R.id.radioGroup);
        tv =(TextView)findViewById(R.id.textView_Prueba);

        // nombre de usuario
        nombre = getIntent().getStringExtra("nombre");
        tv.setText(nombre);



    }// metodo para calcular
    public void Calcular(View view){

        //se recuperan los datos introducidos por los usuarios
        float  edad = Float.parseFloat(et_edad.getText().toString());
        float altura = Float.parseFloat(et_altura.getText().toString());
        float peso = Float.parseFloat(et_peso.getText().toString());
        float cuello = Float.parseFloat(et_cuello.getText().toString());
        float cadera = Float.parseFloat(et_cadera.getText().toString());
        float cintura = Float.parseFloat(et_cintura.getText().toString());

        //Logica para radio button
        if(rbt_Hombre.isChecked()== true){
            String Hombre = "Hombre";
            Hombre = getIntent().getStringExtra("Hombre");


            //Calorias
            calorias = (float) (66.5 + (13.8 *  peso) + (5 * altura) - (6.8 * edad));

            //IMC
            imc = (float) 10000 * peso / (altura * altura);

//porcentaje de grasa
            numero = (float) altura / 100;

            raiz = (double) Math.sqrt(numero);

            denominador = (float) (numero * raiz);

            preGrasa = (float) cintura / denominador;

            porGrasa = (float) (preGrasa - 20);
            //porGrasa = (float) porGrasa;

//KIlogramos de grasa
            kgGrasa = (float) peso * porGrasa / 100;

// Kilogramos de musculo
            kgMusculo = (float) (peso - kgGrasa - 3.2);


//Proteina dia
            diaProteina = (float) 2.2 * kgMusculo;

//Para Mantener
            pm_ejercicio = (float) (calorias * 1.2);
//3-5 dias
            tres_dias = (float) (calorias * 1.55);
//6-7 dias
            seis_dias = (float) (calorias * 1.725);

            //Para Bajar
//Proteina dia
            pb_ejercicio = (float) (pm_ejercicio * 0.8);
//3-5 dias
            pb_tresdias = (float) (tres_dias * 0.8);
//6-7 dias
            pb_seisdias = (float) (seis_dias * 0.8);


            // si es seleccionado mujer
        }else if(rbt_Mujer.isChecked()== true){
            String Mujer = "Mujer";
            Mujer = getIntent().getStringExtra("Mujer");


            // Calorias
            calorias = (float) (66.5 + (9.6 * peso) + (1.85 * altura) - (4.7 * edad));

            //IMC
            imc = (float) 10000 * peso / (altura * altura);

            //Porcentaje de Grasa

            numero = (float) altura / 100;

            raiz = (double) Math.sqrt(numero);

            denominador = (float) (numero * raiz);

            preGrasa = (float) cadera / denominador;

            porGrasa = (float) (preGrasa - 18);
            //porGrasa = (float) porGrasa;

            //Kilogramo Grasa
            kgGrasa = (float) peso * porGrasa / 100;

            //Kilogramo Musculo
            kgMusculo = (float) (peso - kgGrasa - 2.7);

            //Proteina dia
            diaProteina = (float) (2.2 * kgMusculo);


//Para Mantener mujer
            pm_ejercicio = (float) (calorias * 1.2);
//3-5 dias
            tres_dias = (float) (calorias * 1.55);
//6-7 dias
            seis_dias = (float) (calorias * 1.725);

            //Para Bajar
//Proteina dia
            pb_ejercicio = (float) (pm_ejercicio * 0.8);
//3-5 dias
            pb_tresdias = (float) (tres_dias * 0.8);
//6-7 dias
            pb_seisdias = (float) (seis_dias * 0.8);

        }
        //se envio de datos a la activity siguiente
        Intent intent = new Intent(this, Resultados.class);

        nombre = String.valueOf(nombre);
        intent.putExtra("nombre", nombre);
        startActivity(intent);


        string_calorias = String.valueOf(calorias);
        intent.putExtra("calorias", string_calorias);
        startActivity(intent);

        string_imc = String.valueOf(imc);
        intent.putExtra("imc", string_imc);
        startActivity(intent);

        string_porGrasa = String.valueOf(porGrasa);
        intent.putExtra("porGrasa", string_porGrasa);
        startActivity(intent);

        string_kgGrasa = String.valueOf(kgGrasa);
        intent.putExtra("kgGrasa", string_kgGrasa);
        startActivity(intent);

        string_kgMusculo = String.valueOf(kgMusculo);
        intent.putExtra("kgMusculo", string_kgMusculo);
        startActivity(intent);

        string_diaProteina = String.valueOf(diaProteina);
        intent.putExtra("diaProteina", string_diaProteina);
        startActivity(intent);

        //para mantener envio de datos

        string_pmejercicio = String.valueOf(pm_ejercicio);
        intent.putExtra("pmejercicio", string_pmejercicio);
        startActivity(intent);

        string_tres_dias = String.valueOf(tres_dias);
        intent.putExtra("pmtresdias", string_tres_dias);
        startActivity(intent);

        string_seis_dias = String.valueOf(seis_dias);
        intent.putExtra("pmseisdias",  string_seis_dias);
        startActivity(intent);

        ////////para bajar envio de datos
        string_pbejercicio = String.valueOf(pb_ejercicio);
        intent.putExtra("pbejercicio", string_pbejercicio);
        startActivity(intent);

        string_tres_dias = String.valueOf(pb_tresdias);
        intent.putExtra("pbtresdias", string_tres_dias);
        startActivity(intent);

        string_seis_dias = String.valueOf(pb_seisdias);
        intent.putExtra("pbseisdias", string_seis_dias);
        startActivity(intent);
        finish();

    }

    }