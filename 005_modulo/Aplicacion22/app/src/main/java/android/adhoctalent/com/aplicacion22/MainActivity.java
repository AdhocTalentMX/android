package android.adhoctalent.com.aplicacion22;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    NotificationCompat.Builder mBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // creando la notificacion
        mBuilder =
                new NotificationCompat.Builder(MainActivity.this);

        mBuilder.setSmallIcon(android.R.drawable.stat_sys_warning);
        mBuilder.setLargeIcon((((BitmapDrawable)getResources()
                .getDrawable(R.mipmap.ic_launcher)).getBitmap()));
        mBuilder.setContentTitle("Mensaje de la notificacion");
        mBuilder.setContentText("Ejemplo de notificación.");
        mBuilder.setTicker("Alerta!");
        mBuilder.setContentInfo("REV");
        mBuilder.setAutoCancel(true);

        // hacer que la notificacion mande la actividad

        Intent notIntent =
                new Intent(MainActivity.this, MainActivity.class);
        notIntent.putExtra("nombre","Esto es una prueba");
        notIntent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent contIntent =
                PendingIntent.getActivity(
                        MainActivity.this, 0, notIntent, 0);
        mBuilder.setContentIntent(contIntent);

    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.e("Notificaciones", "Codigo: " + requestCode);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        Bundle extras = intent.getExtras();
        if(extras != null){
            if(extras.containsKey("nombre"))
            {
                String msg = extras.getString("nombre");
                Log.e("Nombre1: " , msg);
            }
        }

    }

    public void mandaNotificacion(View view)
    {

        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(1234, mBuilder.build());
    }
}
