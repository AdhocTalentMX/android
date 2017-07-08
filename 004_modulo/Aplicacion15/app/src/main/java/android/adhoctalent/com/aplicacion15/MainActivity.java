package android.adhoctalent.com.aplicacion15;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("Tag","Metodo Oncreate");
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("TAG", "Metodo restart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("TAG", "Metodo pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("TAG", "Metodo stop");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Tag", "Metodo Start");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("TAG", "Metodo Resume ");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("TAG", "Se ejecuto onDestroy");
    }
}
