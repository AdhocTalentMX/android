package com.adhoctalend.cursoadnroid.aplicacion2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Description:
 *
 * Copyright 2017 AdhocTalent
 *
 * Created by luiscobian on 7/1/17.
 * Edit by Martin Lopez on 7/3/17
 */

public class MainActivity extends
        AppCompatActivity {

    EditText edNum1;
    EditText edNum2;
    TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edNum1 = (EditText)findViewById(R.id.edNum1);
        edNum2 = (EditText) findViewById(R.id.edNum2);
        txtResultado = (TextView) findViewById
                (R.id.txtResultado);


    }

    public void hacerSuma(View v){
        Log.e("Accion Boton ", "Se presiono");
        Toast.makeText
                (this, "Se presiono",
           Toast.LENGTH_SHORT).show();
        // Proceso de la suma
        int num1 = Integer.parseInt(edNum1
                .getText().toString());
        int num2 = Integer.parseInt(edNum2
                    .getText().toString());
        // se hace la suma
        int suma = num1 + num2;
        txtResultado.setText("El resultado es "
                + suma);

    }
}
