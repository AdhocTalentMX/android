package com.adhoctalend.cursoadnroid.aplicacion3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
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

    EditText edNum1;
    EditText edNum2;
    TextView txtResultado;
    Button boton;
    RadioButton rdSuma;
    RadioButton rdResta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edNum1 = (EditText) findViewById
                (R.id.edNum1);
        edNum2 = (EditText) findViewById
                (R.id.edNum2);
        txtResultado = (TextView) findViewById
                (R.id.txtResultado);
        boton = (Button) findViewById(R.id.button);
        rdSuma = (RadioButton)
                findViewById(R.id.rdSuma);
        rdResta = (RadioButton)
                findViewById(R.id.rdResta);

        boton.setOnClickListener(new
                 View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt
                           (edNum1.getText().toString());
                int num2 = Integer.parseInt(edNum2.getText()
                        .toString());
                int resultado = rdSuma.isChecked()?
                                num1 + num2 :
                                num1 - num2 ;
                txtResultado.setText("El resultado es "
                             + resultado);
            }
        });

    }
}
