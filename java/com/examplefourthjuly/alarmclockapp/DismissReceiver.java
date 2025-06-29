package com.examplefourthjuly.alarmclockapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.core.app.NotificationManagerCompat;

public class DismissReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManagerCompat.from(context).cancel(100); // cancel the notification
        Toast.makeText(context, "Alarm Dismissed", Toast.LENGTH_SHORT).show();
    }
}
