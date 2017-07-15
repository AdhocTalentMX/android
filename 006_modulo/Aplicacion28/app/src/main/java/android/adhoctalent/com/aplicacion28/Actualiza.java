package android.adhoctalent.com.aplicacion28;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Actualiza extends AppCompatActivity {

     EditText edNombre;
    EditText edPuesto;
    Button btnGraba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualiza);

        edNombre = (EditText) findViewById(R.id.edNombre);
        edPuesto = (EditText) findViewById(R.id.edPuesto);
        btnGraba = (Button) findViewById(R.id.btnGraba);

        btnGraba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sp =
                        getSharedPreferences("misdatos",
                                Context.MODE_PRIVATE);
                SharedPreferences.Editor editor =
                        sp.edit();
                editor.putString("nombre", edNombre.getText()
                        .toString());
                editor.putString("puesto", edPuesto.getText()
                        .toString());
                editor.commit();
                finish();
            }
        });
    }
}
