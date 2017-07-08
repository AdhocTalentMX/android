package android.adhoctalent.com.apliczcion10;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * Copyright 2017 AdhocTalent
 *
 * Created by luiscobian on 7/1/17.
 * Edit by Martin Lopez on 7/3/17
 */

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    public static List<Contacto> datos = new ArrayList<>();
    RecyclerView rv;

    FloatingActionButton botonFlotante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  soporte para toolbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        rv = (RecyclerView) findViewById(R.id.rv);

        Log.e("Numero datos", String.valueOf(datos.size()));
        actualizaRecycler();
        botonFlotante = (FloatingActionButton) findViewById(R.id.agregarBoton);
        botonFlotante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Intent
                Intent i = new Intent(MainActivity.this, AgregarActividad.class);
                startActivity(i);

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        actualizaRecycler();
    }

    public void actualizaRecycler() {
        AdaptorRecycler ar = new AdaptorRecycler(datos);
        ar.setListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("Dando un clic", "P: " +
                        rv.getChildAdapterPosition(view));
                View v1 = rv.getChildAt(rv.getChildAdapterPosition(view));
                TextView tte = (TextView) v1.findViewById(R.id.cTelefono);
                Log.e("NUMERO AL QUE LLAMARA", tte.getText().toString());
                /// Intención para mandar llamar al numero que se tiene
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + tte.getText().toString()));
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE},225);
                    return;
                }
                try {
                    startActivity(i);
                }catch(Exception e){
                    Snackbar.make(rv,"Imposible hacer la llamada", Snackbar.LENGTH_LONG).show();
                }
            }
        });
        rv.setAdapter(ar);
        rv.hasFixedSize();
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.mi_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String cadena = "";
        switch (item.getItemId())
        {
            case R.id.opcion:
                cadena = "opcion1";
                break;
            case R.id.opcion2:
                cadena = "Opcion 2";
        }
        Toast.makeText(this,cadena, Toast.LENGTH_SHORT).show();
        return super.onOptionsItemSelected(item);
    }
}
