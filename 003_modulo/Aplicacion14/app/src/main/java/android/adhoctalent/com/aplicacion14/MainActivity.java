package android.adhoctalent.com.aplicacion14;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView letrero ;
    Button boton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        letrero = (TextView) findViewById(R.id.txtLetrero);
        boton = (Button) findViewById(R.id.btn_action_1);

        registerForContextMenu(boton);
        registerForContextMenu(letrero);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

         getMenuInflater().inflate(R.menu.mi_menu, menu);
         menu.add(Menu.NONE, 40, Menu.NONE, "Opcion Nueva");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemId = item.getItemId();

        switch (itemId) {
            case R.id.opcion1:
                Log.e("opcion", "opcion 1 seleccionada");
                break;
            case R.id.opcion2:
                Log.e("opcion", "opcion 2 seleccionada");
                break;
            case 40:
                Log.e("opcion", "opcion 3 seleccionada");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if(v instanceof Button)
            getMenuInflater().inflate(R.menu.contextual_1, menu);
        else
            getMenuInflater().inflate(R.menu.contextual_2, menu);




    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        // Obtenemos el id del elemento seleccionado
        int itemId = item.getItemId();
        // Identificamos el elemento de menu seleccionado mediante la comparacion de su id
        switch (itemId) {
            case R.id.contextual_1_a:
                Log.e("opcion", "Contextual a 1 a 1");
                break;
            case R.id.contextual_1_b:
                Log.e("opcion", "Contextual a 1 a 2");
                break;
            case R.id.contextual_2_a:
                Log.e("opcion", "Contextual a 2 a 1");
                break;
            case R.id.contextual_2_b:
                Log.e("opcion","Contextual a 2 a 2");
        }
        return super.onContextItemSelected(item);
    }

}
