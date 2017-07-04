package android.adhoctalent.com.apliczcion10;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Description:
 *
 * Copyright 2017 AdhocTalent
 *
 * Created by luiscobian on 7/1/17.
 * Edit by Martin Lopez on 7/3/17
 */

public class AgregarActividad extends AppCompatActivity {

    EditText txtNombre;
    EditText txtTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_actividad);

        txtNombre = (EditText) findViewById(R.id.agNombre);
        txtTelefono = (EditText) findViewById(R.id.agTelefono);

        Button boton = (Button) findViewById(R.id.button);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = txtNombre.getText().toString();
                String telefono = txtTelefono.getText().toString();
                Contacto contacto = new Contacto(nombre, telefono);
                MainActivity.datos.add(contacto);
                finish();
            }
        });

    }
}






