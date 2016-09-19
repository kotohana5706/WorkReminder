package com.project.hyemdooly.workreminder;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.codetroopers.betterpickers.calendardatepicker.CalendarDatePickerDialogFragment;
import com.codetroopers.betterpickers.radialtimepicker.RadialTimePickerDialogFragment;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements CalendarDatePickerDialogFragment.OnDateSetListener, RadialTimePickerDialogFragment.OnTimeSetListener {


    public EditText dialogDate;
    private EditText dialogTime;
    private static final String FRAG_TAG_DATE_PICKER = "Select Date";
    private static final String FRAG_TAG_TIME_PICKER = "Select Time";
    private View dialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.add_work_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Add your Work!", Toast.LENGTH_SHORT);
                // getApplicationContext : 현재 실행되고 있는 앱의 실행 환경
                LayoutInflater inflater = getLayoutInflater();
                dialogView = inflater.inflate(R.layout.add_work_dialog, null);
                // null 자리는 ViewGroup root
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this); // Activity가 Context를 상속받음
                builder.setView(dialogView).show();
                dialogDate = (EditText) dialogView.findViewById(R.id.dialog_date);

                dialogDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        CalendarDatePickerDialogFragment cdp = new CalendarDatePickerDialogFragment()
                                .setOnDateSetListener(MainActivity.this)
                                .setFirstDayOfWeek(Calendar.SUNDAY);
                        cdp.show(getSupportFragmentManager(), FRAG_TAG_DATE_PICKER);

                    }
                });

                dialogTime = (EditText) dialogView.findViewById(R.id.dialog_time);

                dialogTime.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        RadialTimePickerDialogFragment rtpd = new RadialTimePickerDialogFragment()
                                .setOnTimeSetListener(MainActivity.this)
                                .setForced12hFormat();
                        rtpd.show(getSupportFragmentManager(), FRAG_TAG_TIME_PICKER);
                    }
                });

            }
        });

    }


    @Override
    public void onDateSet(CalendarDatePickerDialogFragment dialog, int year, int monthOfYear, int dayOfMonth){
        dialogDate.setText(dialog.getResources().getString(R.string.calendar_date_picker_result_values, year, monthOfYear, dayOfMonth));
    }

    @Override
    public void onTimeSet(RadialTimePickerDialogFragment dialog, int hourOfDay, int minute){
        dialogTime.setText(dialog.getResources().getString(R.string.calendar_time_picker_result_values, hourOfDay, minute));
    }



}

