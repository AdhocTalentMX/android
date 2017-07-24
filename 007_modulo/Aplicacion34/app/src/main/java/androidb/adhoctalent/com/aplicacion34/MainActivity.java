package androidb.adhoctalent.com.aplicacion34;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    Retrofit adaptador;
    RetrofitInterface iServicios;

    TextView txtContenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        txtContenido = (TextView) findViewById(R.id.txtContenido);

        // crear adaptor
        adaptador = new Retrofit.Builder()
                .baseUrl(RetrofitInterface.URL)
                .addConverterFactory(GsonConverterFactory
                        .create())
                .build();
        // carga interface   github.com/cobymotion
        iServicios = adaptador.create(RetrofitInterface.class);
        // genera la llamada
        Call<List<Personas>> llamada = iServicios.getPersonas();
        // hace la peticion al servicio HTTP
        llamada.enqueue(new Callback<List<Personas>>() {
            @Override
            public void onResponse(Call<List<Personas>> call,
                                   Response<List<Personas>>
                                           response) {
                if(!response.isSuccessful())
                {
                    Log.e("Error","OCrriuo algo");
                    return;
                }
                txtContenido.setText("");
                List<Personas> datos = response.body();
                for (Personas p: datos )
                {
                    txtContenido.append(p.getNombre() + " "
                         + p.getDomicilio() + " :: ");
                }
            }

            @Override
            public void onFailure(Call<List<Personas>> call, Throwable t) {

            }
        });


    }
}








