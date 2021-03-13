package com.example.backgrnd;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MyService extends Service {
    @Override
    public void onCreate() {
        super.onCreate();
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
             NotificationCompat.Builder builder=new NotificationCompat.Builder(this,"messages")
                    .setContentText("this is running in Background")
                    .setContentTitle("Flutter backgound")
                     .setSmallIcon(R.drawable.launch_background);
            NotificationManagerCompat manager=NotificationManagerCompat.from(this);
            manager.notify(101,builder.build());
            startForeground(101,builder.build());
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
