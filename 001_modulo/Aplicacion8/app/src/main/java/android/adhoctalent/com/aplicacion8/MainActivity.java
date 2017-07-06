package android.adhoctalent.com.aplicacion8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
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

public class MainActivity extends AppCompatActivity {



    ImageButton boton;
    int contador = 0 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View vista = findViewById(R.id.idBoton);

         boton = (ImageButton) vista;

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                contador ++;
                LayoutInflater infla  = getLayoutInflater();
                View layout = infla.inflate(R.layout.toast_layout, null);

                TextView anuncio = (TextView) layout.findViewById(R.id.textView);
                anuncio.setText("Valor:" + contador);

                Toast t = new Toast(getApplicationContext());
                t.setDuration(Toast.LENGTH_LONG);
                t.setView(layout);

                t.show();


            }
        });

    }
}
