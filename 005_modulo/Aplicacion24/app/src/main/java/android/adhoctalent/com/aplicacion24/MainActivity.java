package android.adhoctalent.com.aplicacion24;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements Results {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                DialogoConfirmar dialogo = DialogoConfirmar.newInstance(MainActivity.this);
                dialogo.show(fragmentManager, "tagAlerta");
            }
        });
    }

    @Override
    public void returnValue(boolean res) {
        Log.e("Regreso", String.valueOf(res));
    }
}
