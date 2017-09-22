package android.adhoctalent.com.aplicacion9_1;

import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * Copyright 2017 AdhocTalent
 *
 * Created by luiscobian on 7/1/17.
 * Edit by Martin Lopez on 7/3/17
 */

public class MainActivity extends AppCompatActivity {

    List<Materia> boleta;
    TableLayout tableLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Datas
       /* boleta = new ArrayList<>();
        boleta.add(new Materia("Matematicas", 78));
        boleta.add(new Materia("Programación", 85));
        boleta.add(new Materia("Historia", 100));
        boleta.add(new Materia("Estadistica", 78));
        boleta.add(new Materia("Probabilidad", 92));
        boleta.add(new Materia("Diseño", 78));
        boleta.add(new Materia("Matematicas", 78));
        boleta.add(new Materia("Programación", 85));
        boleta.add(new Materia("Historia", 100));
        boleta.add(new Materia("Estadistica", 78));
        boleta.add(new Materia("Probabilidad", 92));
        boleta.add(new Materia("Diseño", 78));
        boleta.add(new Materia("Matematicas", 78));
        boleta.add(new Materia("Programación", 85));
        boleta.add(new Materia("Historia", 100));
        boleta.add(new Materia("Estadistica", 78));
        boleta.add(new Materia("Probabilidad", 92));
        boleta.add(new Materia("Diseño", 78));

        tableLayout =  (TableLayout) findViewById(R.id.table);

        actualizaTable(boleta);*/
    }

    public void actualizaTable(List<Materia> boleta){
        //cargamos en la vista la boleta
        tableLayout.removeAllViews();
        // Encabezado de la tabla
        TableRow renglon = new TableRow(this);
        renglon.setBackgroundColor( getResources().getColor(R.color.encabezado));
        // columna 1
        TextView tv = new TextView(this);
        tv.setLayoutParams(new TableRow.LayoutParams(0)); // propiedad layout_column
        tv.setPadding(5,5,5,5);
        tv.setText("Materia");
        tv.setTextColor(Color.WHITE);
        renglon.addView(tv);
        // columna 2
        tv = new TextView(this);
        tv.setLayoutParams(new TableRow.LayoutParams(2)); // propiedad layout_column
        tv.setPadding(5,5,5,5);
        tv.setText("Calificación");
        tv.setTextColor(Color.WHITE);
        renglon.addView(tv);
        tableLayout.addView(renglon);
        //Empieza a poner las materias
        float suma = 0;  // var para poder calcular el promedio

        for (Materia materia: boleta)
        {
            suma += (float)materia.getCalificaciones();
            // Agregamos el renglon
            renglon = new TableRow(this);
            // Agregamos los nombres de las materias
            tv = new TextView(this);
            tv.setLayoutParams(new TableRow.LayoutParams(0)); // propiedad layout_column
            tv.setPadding(5,5,5,5);
            tv.setText(materia.getNombre());
            renglon.addView(tv);
            // agregamos sus calificaciones
            tv = new TextView(this);
            tv.setLayoutParams(new TableRow.LayoutParams(2)); // propiedad layout_column
            tv.setPadding(5,5,5,5);
            tv.setText(String.valueOf(materia.getCalificaciones()));
            renglon.addView(tv);
            tableLayout.addView(renglon);
        }

        // Mostramos el promedio
        // calculo del promedio
        float promedio = suma!=0? suma/boleta.size():0.0f;
        // linea de division
        renglon = new TableRow(this);
        renglon.setLayoutParams(new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 5));
        renglon.setBackgroundColor(getResources().getColor(R.color.lineSeparated));
        tv = new TextView(this);
        tv.setHeight(5);
        renglon.addView(tv);
        tableLayout.addView(renglon);
        ///renglon final
        renglon = new TableRow(this);
        // columna promedio
        tv = new TextView(this);
        tv.setPadding(5,5,5,5);
        tv.setText("Promedio: ");
        tv.setTextColor(getResources().getColor(R.color.encabezado));
        tv.setLayoutParams(new TableRow.LayoutParams(1));
        renglon.addView(tv);
        // columna cantidad del promedio
        tv = new TextView(this);
        tv.setPadding(5,5,5,5);
        tv.setText(String.format("%.1f",promedio));
        tv.setTextColor(getResources().getColor(R.color.encabezado));
        tv.setLayoutParams(new TableRow.LayoutParams(1));
        renglon.addView(tv);
        tableLayout.addView(renglon);




    }
}
