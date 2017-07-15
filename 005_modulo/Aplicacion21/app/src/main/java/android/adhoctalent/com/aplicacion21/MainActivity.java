package android.adhoctalent.com.aplicacion21;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Description:
 *
 * Copyright 2017 AdhocTalent
 *
 * Created by luiscobian on 7/1/17.
 * Edit by Martin Lopez on 7/3/17
 */

public class MainActivity extends AppCompatActivity {

    Button toast1, toast2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toast1 = (Button) findViewById(R.id.idToast1);
        toast2 = (Button) findViewById(R.id.idToast2);

        EventoToast eventos = new EventoToast(getApplicationContext());

        toast1.setOnClickListener(eventos);
        toast2.setOnClickListener(eventos);

    }

}

class EventoToast implements View.OnClickListener{

    Context context;

    public EventoToast(Context context) {
        this.context = context;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.idToast1:
                Toast.makeText(context, "Este es un toast normal", Toast.LENGTH_SHORT).show();
                break;
            case R.id.idToast2:
                Toast toast = Toast.makeText(context,"Toast con gravity",Toast.LENGTH_LONG);
                toast.setGravity(Gravity.TOP|Gravity.LEFT,100,0);
                toast.show();

        }
    }
}
