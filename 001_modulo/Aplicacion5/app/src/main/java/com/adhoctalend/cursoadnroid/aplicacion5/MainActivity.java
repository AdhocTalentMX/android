package com.adhoctalend.cursoadnroid.aplicacion5;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Description:
 *
 * Copyright 2017 AdhocTalent
 *
 * Created by luiscobian on 7/1/17.
 * Edit by Martin Lopez on 7/3/17
 */

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    TextView txtLetrero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner = (Spinner) findViewById
                          (R.id.spTipoLetra);
        txtLetrero = (TextView) findViewById
                (R.id.txtLetrero);
        // Arreglo de opciones
        String opciones[] = {"Negrita","Cursiva"};
        // Adaptador que toma los datos del spinner

        ArrayAdapter<String> adaptadorSpinner =
                new ArrayAdapter<String>(this,
              android.R.layout.simple_spinner_item,
                        opciones);
        spinner.setAdapter(adaptadorSpinner);

        spinner.setOnItemSelectedListener(new AdapterView.
                OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?>
               adapterView, View view, int i, long l) {
                String opcionSeleccionada =
                        spinner.getSelectedItem()
                                .toString();
                if(opcionSeleccionada.equals("Negrita")){
                    txtLetrero.setTypeface(null,
                            Typeface.BOLD);
                } else
                    txtLetrero.setTypeface(null,
                            Typeface.ITALIC);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
