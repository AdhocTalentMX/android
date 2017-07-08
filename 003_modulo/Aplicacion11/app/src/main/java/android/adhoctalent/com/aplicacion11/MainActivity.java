package android.adhoctalent.com.aplicacion11;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Description:
 *
 * Copyright 2017 AdhocTalent
 *
 * Created by luiscobian on 7/1/17.
 * Edit by Martin Lopez on 7/3/17
 */

public class MainActivity extends AppCompatActivity {

    EditText editNumber;
    FloatingActionButton boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editNumber = (EditText) findViewById(R.id.numTelefono);
        boton = (FloatingActionButton) findViewById(R.id.actionCall);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + editNumber.getText().toString()));
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CALL_PHONE},255);
                    return;
                }
                startActivity(i);
            }
        });

    }
}
