package com.adhoctalend.cursoadnroid.aplicacion6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtLetrero;
    ListView lvProductos;
    // Agreglo con datos
    String productos[] = {"uno", "dos", "tres", "cuatro",
            "quinto", "sexto", "octavo", "noveno",
            "decimo", "onceavo", "doceavo", "treceavo"};

    String categorias[] = {"Comida", "Papel", "Comida", "Otro",
            "Otra", "Electronicos", "Limpieza", "Papel",
            "Infantil", "Farmacia", "Electronicos", "Comida"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtLetrero = (TextView) findViewById(R.id.txtLetrero);
        lvProductos = (ListView) findViewById(R.id.lvProductos);
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.
                        R.layout.simple_list_item_1, productos);
        lvProductos.setAdapter(adapter);

        lvProductos.setOnItemClickListener(new AdapterView.
                OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView,
                                    View view, int i, long l) {
                txtLetrero.setText("Categoria: " +
                              categorias[i]);
            }
        });
    }
}
