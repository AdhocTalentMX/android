package com.adhoctalend.cursoadnroid.aplicacion4;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * Description:
 *
 * Copyright 2017 AdhocTalent
 *
 * Created by luiscobian on 7/1/17.
 * Edit by Martin Lopez on 7/3/17
 */

public class MainActivity extends AppCompatActivity {

    EditText edNombre;
    EditText edCiudad;
    CheckBox chNegrita;
    CheckBox chCursiva;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edNombre = (EditText) findViewById
                          (R.id.edNombre);
        edCiudad = (EditText) findViewById
                           (R.id.edCiudad);
        chNegrita = ( CheckBox) findViewById
                (R.id.chNegrita);
        chCursiva = (CheckBox) findViewById
                  (R.id.chCursiva);
    }

    public void verificaCh(View v){

        if(chNegrita.isChecked()
                && chCursiva.isChecked()){
            edNombre.setTypeface(null,
                    Typeface.BOLD_ITALIC);
            edCiudad.setTypeface(null,
                    Typeface.BOLD_ITALIC);
        }
        else if(chNegrita.isChecked())
        {
            edNombre.setTypeface(null,
                    Typeface.BOLD);
            edCiudad.setTypeface(null,
                    Typeface.BOLD);
        }
        else if(chCursiva.isChecked())
        {
            edNombre.setTypeface(null,
                    Typeface.ITALIC);
            edCiudad.setTypeface(null,
                    Typeface.ITALIC);
        }
        else {
            edNombre.setTypeface(null,
                    Typeface.NORMAL);
            edCiudad.setTypeface(null,
                    Typeface.NORMAL);
        }
    }
}
