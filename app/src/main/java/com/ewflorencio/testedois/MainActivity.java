package com.ewflorencio.testedois;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    TextView txtTime;
    TimePicker timePicker;
    AlarmManager alarmManager;
    PendingIntent intentPendente;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        txtTime = (TextView) findViewById(R.id.text);
        timePicker = (TimePicker) findViewById(R.id.time);

        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        Calendar calendario = Calendar.getInstance();

        final Intent intent = new Intent(this.getApplicationContext(), OneSetTimeReciver.class);

        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

                if (Build.VERSION.SDK_INT >=23){

                    calendario.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
                    calendario.set(Calendar.MINUTE, timePicker.getMinute());


                }else{

                    calendario.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
                    calendario.set(Calendar.MINUTE, timePicker.getCurrentMinute());

                }


                intentPendente = PendingIntent.getBroadcast(MainActivity.this,0,intent, PendingIntent.FLAG_UPDATE_CURRENT );

                alarmManager.set(AlarmManager.RTC_WAKEUP,calendario.getTimeInMillis(),intentPendente);

                txtTime.setText("A tarefa foi agendada para o horario: " + hourOfDay +":" + minute);


            }
        });

    }
}