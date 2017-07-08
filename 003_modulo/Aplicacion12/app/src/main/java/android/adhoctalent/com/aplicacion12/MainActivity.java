package android.adhoctalent.com.aplicacion12;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean autentificado;
    FloatingActionButton boton;
    TextView nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        nombre = (TextView) findViewById(R.id.txtusuario);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("Prueba", "Esto es una prueba");
                Intent i = new Intent(MainActivity.this, Autentificacion.class);
                i.putExtra("autentificado",autentificado);
                startActivityForResult(i,1236);
            }
        });

    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("txt_later", nombre.getText().toString());
        outState.putBoolean("bool_auth",autentificado);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        String nombres = savedInstanceState.getString("txt_later");
        autentificado = savedInstanceState.getBoolean("bool_auth");
        nombre.setText(nombres);
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {

        if(intent == null )
            return;
        autentificado = intent.getBooleanExtra("auth",true);

        String nombreIntencion = intent.getStringExtra("nombre");
        if(autentificado) {
            autentificado = false;
            nombre.setText("No esta Autentificado");
        }
        else
        {
            autentificado = true;
            nombre.setText(nombreIntencion);
        }

    }


}
