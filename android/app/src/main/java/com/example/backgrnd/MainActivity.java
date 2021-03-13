package com.example.backgrnd;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugins.GeneratedPluginRegistrant;

public class MainActivity extends FlutterActivity {
  private Intent forService;
    public static int ALARM_TYPE_RTC = 100;
    private static AlarmManager alarmManagerRTC;
    private static PendingIntent alarmIntentRTC;

    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        GeneratedPluginRegistrant.registerWith(flutterEngine);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // GeneratedPluginRegistrant.registerWith(this);
        forService=new Intent(MainActivity.this,AlarmReceiver.class);
//        if(Build.VERSION.SDK_INT>Build.VERSION_CODES.O){
//            startForegroundService(forService);
//
//        }else{
//            startService(forService);
//           }

//        //Setting alarm pending intent
       alarmIntentRTC = PendingIntent.getBroadcast(this, 101,forService,0);
//
//        //getting instance of AlarmManager service
        alarmManagerRTC = (AlarmManager)this.getSystemService(ALARM_SERVICE);
//
//        //Setting alarm to wake up device every day for clock time.
//        //AlarmManager.RTC_WAKEUP is responsible to wake up device for sure, which may not be good practice all the time.
//        // Use this when you know what you're doing.
//        //Use RTC when you don't need to wake up device, but want to deliver the notification whenever device is woke-up
//        //We'll be using RTC.WAKEUP for demo purpose only
      long crnttime=System.currentTimeMillis();
       long tenseconds=1000*10;
        alarmManagerRTC.set(AlarmManager.RTC_WAKEUP,
                crnttime+tenseconds, alarmIntentRTC);
       // NotificationHelper.scheduleRepeatingElapsedNotification(this);
        //NotificationHelper.enableBootReceiver(this);
    }
}
