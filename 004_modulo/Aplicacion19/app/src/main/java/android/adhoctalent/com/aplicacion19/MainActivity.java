package android.adhoctalent.com.aplicacion19;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    EditText edDireccion;
    TextView txtResultado;
    TextView txtStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /// Inicializamos los elementos
        edDireccion = (EditText) findViewById(R.id.edDireccion);
        txtResultado = (TextView) findViewById(R.id.txtResultado);
        txtStatus = (TextView) findViewById(R.id.txtStatus);

        ImageButton boton = (ImageButton) findViewById(R.id.btnDescarga);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DescargaAsincrona clase = new DescargaAsincrona();
                clase.execute(edDireccion.getText().toString());
            }
        });

    }

        class DescargaAsincrona extends AsyncTask<String, Integer, String>{

            @Override
            protected void onPreExecute() {
                txtStatus.setText("Iniciando la descarga ......");
                txtResultado.setText("Esperando resultado....");
                super.onPreExecute();
            }

            @Override
            protected String doInBackground(String... strings) {
                Integer contador = 0;
                try {
                    URL url =null;
                    url = new URL(strings[0]);
                    URLConnection con = url.openConnection();
                    BufferedReader lector =
                            new BufferedReader
                                    (new InputStreamReader(con.getInputStream()));
                    String line ="";
                    String resultado = "";
                    while ((line = lector.readLine()) != null){
                        resultado+=line;
                        contador++;
                        publishProgress(contador);
                        Thread.sleep(200);
                    }
                    return resultado;
                }catch (Exception e) {
                    Log.e("Error", "Ocurrio un error: " + e.toString());
                }
                return "";
            }

            @Override
            protected void onProgressUpdate(Integer... values) {
                txtStatus.setText("Numeros leidas: " + values[0]);
                super.onProgressUpdate(values);
            }

            @Override
            protected void onPostExecute(String s) {
                txtResultado.setText(s);
                super.onPostExecute(s);
            }
        }

    }

