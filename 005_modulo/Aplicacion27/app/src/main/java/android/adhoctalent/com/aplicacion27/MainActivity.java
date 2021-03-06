package android.adhoctalent.com.aplicacion27;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

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
                DialogoPersonalizado dialogo = new DialogoPersonalizado();
                dialogo.show(fragmentManager, "dialogo");
            }
        });

    }
}
