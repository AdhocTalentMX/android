package android.adhoctalent.com.aplicacion12;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.widget.EditText;

public class Autentificacion extends AppCompatActivity {

    boolean bol ;
    EditText dtx ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autentificacion);
        Intent i = getIntent();
        bol = i.getBooleanExtra("autentificado",false);
        if(bol)
        {
            Intent intent = new Intent();
            intent.putExtra("auth",bol);
            setResult(RESULT_OK,intent);
            finish();
        }

        dtx = (EditText) findViewById(R.id.edUsuario);

        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombre = dtx.getText().toString();
                Intent intent = new Intent();
                intent.putExtra("auth",false);
                intent.putExtra("nombre",nombre);
                setResult(RESULT_OK, intent);
                finish();

            }
        });

    }
}
