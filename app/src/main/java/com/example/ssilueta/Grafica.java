package com.example.ssilueta;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LegendEntry;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;

public class Grafica extends AppCompatActivity {
    LineChart mpLineChart;
    int colorArray[] = {R.color.color1, R.color.color2, R.color.color3};
    // colores para la leyenda
    int[] colorClassArray = new int[]{Color.BLACK, Color.RED, Color.BLUE};
    //nombre de datos de la legenda
    String[] legendName = {"%Grasa","IMC","KgMusculo"};

    String string_porGrasa, string_imc, string_kgMusculo;
    public double porGrasa, imc, kgMusculo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grafica);

        mpLineChart = (LineChart) findViewById(R.id.line_chart);


        //datos recibidos de resultados
        string_porGrasa = getIntent().getStringExtra("porGrasa");
        porGrasa = Double.parseDouble(string_porGrasa);

        string_imc = getIntent().getStringExtra("imc");
        imc = Double.parseDouble(string_imc);

        string_kgMusculo = getIntent().getStringExtra("kgMusculo");
        kgMusculo = Double.parseDouble(string_kgMusculo);


        LineDataSet lineDataSet1 = new LineDataSet(dataValues1(), "Data set 1");
        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(lineDataSet1);


        // estilo de la linea y grafica
        //mpLineChart.setBackgroundColor(Color.GREEN); color de fondo
        mpLineChart.setNoDataText("No Data");// etiqueta cuando no haya datos
        mpLineChart.setNoDataTextColor(Color.BLUE);// color de etiqueta

        mpLineChart.setDrawGridBackground(true);// sombreado al final del grafico
        mpLineChart.setDrawBorders(true);// para los bordes
        mpLineChart.setBorderColor(Color.BLACK);// color de bordes
        //mpLineChart.setBorderWidth(5);// grosor de border

        lineDataSet1.setLineWidth(4); //grosor de linea
        lineDataSet1.setColor(Color.RED);//color de linea
        //lineDataSet1.setDrawCircles(true);// colocar o quitar circulos en las puntas
        //lineDataSet1.setDrawCircleHole(true);//rellenar o no ciculo de las puntas
        //lineDataSet1.setCircleColor(Color.GREEN);// color de linea del circulo de las puntas
       // lineDataSet1.setCircleHoleColor(Color.GREEN);//relleno del circulo verde
        //lineDataSet1.setCircleRadius(10);// tamaño de la linea del circulo
        //lineDataSet1.setCircleHoleRadius(5);// tamaño del color de fondo del circulo
        lineDataSet1.setValueTextSize(15);// tamaño de los numero de las puntas
        lineDataSet1.setValueTextColor(Color.BLUE);// color de los numeros delas puntas
        // lineDataSet1.enableDashedLine(5,10,0);// forma punteada de la linea
        lineDataSet1.setColors(colorArray, Grafica.this);// multiplec colores en la linea


        //Leyenda
        Legend legend = mpLineChart.getLegend();

        legend.setEnabled(true);// visible la leyenda
        legend.setTextColor(Color.RED);// color a la leyenda
        legend.setTextSize(15);// tamaño del textoleyenda
        legend.setForm(Legend.LegendForm.CIRCLE);//forma de la leyenda
        legend.setFormSize(20);//TAmaño de la forma de leyenda
        legend.setXEntrySpace(10);// espacio entre legendas
        legend.setFormToTextSpace(10);//espacio entre las letras y el icono


        // para colocar 4 datos en la legenda cat, dog, rat, cow
        LegendEntry[] legendEntries = new LegendEntry[3];

        for (int i = 0; i < legendEntries.length; i++) {
            LegendEntry entry = new LegendEntry();
            entry.formColor = colorClassArray[i];
            entry.label = String.valueOf(legendName[i]);
            legendEntries[i] = entry;

        }
        legend.setCustom(legendEntries);
        XAxis xAxis = mpLineChart.getXAxis();
        YAxis yAxisLeft = mpLineChart.getAxisLeft();
        YAxis yAxisRight = mpLineChart.getAxisRight();

        XAxis axis = mpLineChart.getXAxis();
        YAxis yAxis = mpLineChart.getAxisLeft();
        YAxis yAxisRigth = mpLineChart.getAxisRight();

        xAxis.setValueFormatter(new MyAxisValueFormatter());


        //para descripcion de texto zoo
        Description descripcion = new Description();
        descripcion.setText("Silueta");
        descripcion.setTextColor(Color.BLUE);
        descripcion.setTextSize(20);
        mpLineChart.setDescription(descripcion);


        LineData data = new LineData(dataSets);
        mpLineChart.setData(data);
        mpLineChart.invalidate();
        String[] values = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};

    }

    private ArrayList<Entry> dataValues1() {
        ArrayList<Entry> dataVals = new ArrayList<Entry>();
        dataVals.add(new Entry(0, (float) porGrasa));
        dataVals.add(new Entry(1, (float)imc));
        dataVals.add(new Entry(2, (float) kgMusculo));
        return dataVals;
    }

    private class MyAxisValueFormatter extends ValueFormatter {

        @Override
        public String getFormattedValue(float value) {
            mpLineChart.getXAxis().setLabelCount(5);
            return "";
        }


    }
}