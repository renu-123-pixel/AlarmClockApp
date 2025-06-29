package com.examplefourthjuly.alarmclockapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class AlarmActivity extends AppCompatActivity {

    Button snoozeBtn, dismissBtn;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_activity);

        snoozeBtn = findViewById(R.id.snoozeBtn);
        dismissBtn = findViewById(R.id.dismissBtn);

        mediaPlayer = MediaPlayer.create(this, R.raw.alarm_clock);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        dismissBtn.setOnClickListener(v -> {

        });
        snoozeBtn.setOnClickListener(v -> {
            // Snooze: Set alarm again after 5 minutes
            snoozeAlarm();
            stopSoundAndClose();
            AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
            Intent intent = new Intent(this, AlarmReceiver.class);
            PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_IMMUTABLE);
            long snoozeTime = System.currentTimeMillis() + 5 * 60 * 1000; // 5 minutes
            alarmManager.setExact(AlarmManager.RTC_WAKEUP, snoozeTime, pendingIntent);

            Toast.makeText(this, "Snoozed for 5 minutes", Toast.LENGTH_SHORT).show();
            finish();
        });

        dismissBtn.setOnClickListener(v -> {
            Toast.makeText(this, "Alarm dismissed", Toast.LENGTH_SHORT).show();
            stopSoundAndClose();
            finish();
        });
    }
    private void snoozeAlarm() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MINUTE, 5);

        Intent intent = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        try {
            alarmManager.setExactAndAllowWhileIdle(
                    AlarmManager.RTC_WAKEUP,
                    calendar.getTimeInMillis(),
                    pendingIntent
            );
            Toast.makeText(this, "Alarm set successfully", Toast.LENGTH_SHORT).show();
        } catch (SecurityException e) {
            Toast.makeText(this, "Permission denied to schedule exact alarm", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }

    private void stopSoundAndClose() {
        if (mediaPlayer != null && mediaPlayer.isPlaying()) {
            mediaPlayer.stop();
        }
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
        }
    }
}
