package android.adhoctalent.com.aplicacion29;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;

/**
 * Description:
 *
 * Copyright 2017 AdhocTalent
 *
 * Created by luiscobian on 7/1/17.
 * Edit by Martin Lopez on 7/3/17
 */

public class MainActivity extends AppCompatActivity {

    EditText edGuarda;
    TextView txtContenido;
    ImageButton btnGuarda;

    private static final String filename = "miarchivo.txt";
    File file;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Busqueda de los componentes dentro de la vista

        edGuarda = (EditText) findViewById(R.id.txtGraba);
        txtContenido = (TextView) findViewById(R.id.txtContenido);

        btnGuarda = (ImageButton) findViewById(R.id.btnGuardar);

        btnGuarda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                grabaArchivo();
            }
        });


        actualizarContenido();

    }

    private void actualizarContenido() {
        try {

            FileInputStream fis = openFileInput(filename);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            txtContenido.setText("");
            String linea="";
            while((linea=br.readLine())!=null)
                txtContenido.append(linea);
            br.close();
            isr.close();
            fis.close();
        }catch (Exception ex)
        {
            Snackbar.make(btnGuarda,"No se encontro el archivo ", Snackbar.LENGTH_LONG).show();
            Log.e("ERROR", ex.toString());

        }
    }

    private void grabaArchivo()
    {
        try
        {

            FileOutputStream fos = openFileOutput(filename, Context.MODE_APPEND|Context.MODE_PRIVATE);

            OutputStreamWriter fout=
                    new OutputStreamWriter(
                            fos);
            fout.write(edGuarda.getText().toString());
            fout.close();
            Snackbar.make(getCurrentFocus(),"Se grabo correctamente", Snackbar.LENGTH_LONG).show();
            actualizarContenido();
        }
        catch (Exception ex)
        {
            Snackbar.make(getCurrentFocus(),"Hubo un error", Snackbar.LENGTH_LONG).show();
        }
    }
}
