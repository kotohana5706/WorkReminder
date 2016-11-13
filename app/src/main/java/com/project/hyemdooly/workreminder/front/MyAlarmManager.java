package com.project.hyemdooly.workreminder.front;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import java.util.Calendar;

/**
 * Created by songhyemin on 2016. 11. 10..
 */

public class MyAlarmManager extends Activity {


    private static final String TAG = "AlarmManagerAcitivity";
    private static final String INTENT_ACTION = "com.project.hyemdooly.workreminder.front";
    Context context;

    public void setPushAlarm(Calendar calendar){
        Intent intent = new Intent(context, BroadCastAlarmReceiver.class);
        // intent.putExtra("Date", calendar.get);

        PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);
        // context, requestCode, intent, flags
        android.app.AlarmManager alarmManager = (android.app.AlarmManager) context.getSystemService(Context.ALARM_SERVICE);



    }

    public void removePushAlarm(){

    }

    public void setSoonAlarm(){


    }

    public void removeSoonAlarm(){

    }



}
