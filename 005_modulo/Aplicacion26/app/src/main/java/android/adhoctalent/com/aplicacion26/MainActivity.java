package android.adhoctalent.com.aplicacion26;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                //DialogoVariasOpciones dialogo = new DialogoVariasOpciones();
                DialogoCheck dialogo = new DialogoCheck();
                dialogo.show(fragmentManager, "dialogo");
            }
        });
    }

    public void crearArchivo() throws IOException {
        String NOMBREARCHIVO = "ejemplo.txt";
        String cadena = "Hola mundo!";
        FileOutputStream fos = openFileOutput(NOMBREARCHIVO, Context.MODE_PRIVATE);
        fos.write(cadena.getBytes());
        fos.close();
    }
}
