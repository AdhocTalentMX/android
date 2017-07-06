package com.adhoctalend.cursoadnroid.aplicacion7;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import android.widget.SeekBar;

/**
 * Description:
 *
 * Copyright 2017 AdhocTalent
 *
 * Created by luiscobian on 7/1/17.
 * Edit by Martin Lopez on 7/3/17
 */

public class MainActivity extends AppCompatActivity {

    ImageView imagen;
    SeekBar seekBar;

    int iAlto = 52;
    int iAncho = 65;

    float densidad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // calcula las puntos por densidad de la pantalla
        DisplayMetrics metricas = getResources().getDisplayMetrics();
        densidad = metricas.densityDpi;

        //
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        imagen = (ImageView) findViewById(R.id.imgPrueba);

        //
        seekBar.setOnSeekBarChangeListener(new SeekBar.
                OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar,
                                          int i, boolean b) {
               // calculo del cambio
                float ancho = (i + iAncho) * densidad / 160;
                float alto = (i + iAlto) * densidad /160;
                // cambiamos el tamaño
                imagen.getLayoutParams().height = (int) alto;
                imagen.getLayoutParams().width = (int) ancho;
                imagen.requestLayout();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}
