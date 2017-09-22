package android.adhoctalent.com.aplicacion9;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView ;
    int numMem;
    char opPending='N';


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ///
        textView = (TextView) findViewById(R.id.textView);

    }

    public void presiono(View v){

        String numeroActual = textView.getText().toString();
        if(numeroActual.equals("0"))
            numeroActual = "";

        TextView tx = (TextView) v;

        String car = tx.getText().toString();
        if(car.equals("C")) {
            numeroActual = "";
            numMem = 0;
        }
        else if(car.equals("+"))
        {
            numMem = applyOpe(numeroActual);
            opPending = car.charAt(0);
            numeroActual = String.valueOf(numMem);
        }
        else if(car.equals("="))
        {
            numMem = applyOpe(numeroActual);
            opPending = 'N';
            numeroActual = String.valueOf(numMem);
            numMem = 0 ;
        }
        else {
            if(opPending!='N')
                numeroActual = "";

            numeroActual += car;
        }
        textView.setText(numeroActual);
    }

    private int applyOpe(String numeroActual) {
        if(opPending=='N')
            return Integer.parseInt(numeroActual);
        switch (opPending)
        {
            case '+':
                numMem = numMem + Integer.parseInt(numeroActual);
                break;

        }
        return numMem;

    }

}
