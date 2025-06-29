package com.examplefourthjuly.alarmclockapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class SnoozeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent alarmIntent = new Intent(context, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(context, 0, alarmIntent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_IMMUTABLE);

        long snoozeTime = System.currentTimeMillis() + 5 * 60 * 1000; // 5 mins
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, snoozeTime, pendingIntent);

        Toast.makeText(context, "Snoozed for 5 minutes", Toast.LENGTH_SHORT).show();
    }
}
