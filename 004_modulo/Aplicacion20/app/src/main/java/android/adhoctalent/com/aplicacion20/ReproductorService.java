package android.adhoctalent.com.aplicacion20;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

/**
 * Description:
 *
 * Copyright 2017 AdhocTalent
 *
 * Created by luiscobian on 7/1/17.
 * Edit by Martin Lopez on 7/3/17
 */

public class ReproductorService extends Service {


    MediaPlayer player;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }

    @Override
    public void onCreate() {
        player = MediaPlayer.create(this, R.raw.jamendo_licencia);
        player.setLooping(false);
        super.onCreate();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        player.start();
        super.onStart(intent,startId);
    }

    @Override
    public void onDestroy() {
        player.stop();
        super.onDestroy();
    }
}
