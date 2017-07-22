package android.adhoctalent.com.aplicacion28;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtNombre;
    TextView txtPuesto;
    Button btnActualiza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Buscar los componentes

        txtNombre = (TextView) findViewById(R.id.txtNombre);
        txtPuesto = (TextView) findViewById(R.id.txtPuesto);
        btnActualiza = (Button) findViewById(R.id.btnActualiza);



        btnActualiza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this,
                        Actualiza.class);
                startActivity(i);
            }
        });  // https://github.com/AdhocTalentMX

    }

    @Override
    protected void onResume() {
        // Traemos las preferewncias de la aplicacion
        SharedPreferences sp = getSharedPreferences
                ("misdatos", Context.MODE_PRIVATE);
        txtNombre.setText
                (sp.getString("nombre","NO EXISTE"));
        txtPuesto.setText(sp.getString("puesto", "NO EXISTE"));
        super.onResume();
    }
}
