package com.project.hyemdooly.workreminder;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.codetroopers.betterpickers.calendardatepicker.CalendarDatePickerDialogFragment;
import com.codetroopers.betterpickers.radialtimepicker.RadialTimePickerDialogFragment;

import java.util.Calendar;

public class DialogAddWork extends AppCompatActivity implements CalendarDatePickerDialogFragment.OnDateSetListener, RadialTimePickerDialogFragment.OnTimeSetListener {

    private EditText dialogDate;
    private EditText dialogTime;
    private Button buttonOk;
    private Button buttonCancel;
    private static final String FRAG_TAG_DATE_PICKER = "Select Date";
    private static final String FRAG_TAG_TIME_PICKER = "Select Time";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dialogDate = (EditText) findViewById(R.id.dialog_time);
        dialogTime = (EditText) findViewById(R.id.dialog_date);
        buttonOk = (Button) findViewById(R.id.dialog_ok_button);
        buttonCancel = (Button) findViewById(R.id.dialog_cancel_button);
    }

    public void showDialog(View v){

        final AlertDialog addWorkDialog = new AlertDialog.Builder(MainActivity.context).create();
        addWorkDialog.setView(v);
        addWorkDialog.show();

        dialogDate = (EditText) v.findViewById(R.id.dialog_time);
        dialogTime = (EditText) v.findViewById(R.id.dialog_date);
        buttonOk = (Button) v.findViewById(R.id.dialog_ok_button);
        buttonCancel = (Button) v.findViewById(R.id.dialog_cancel_button);

        dialogDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // See Calendar
                showDatePicker(DialogAddWork.this);
            }
        });

        dialogTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // See Clock
                showTimePicker(DialogAddWork.this);
            }
        });

        buttonOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addWorkDialog.dismiss();
            }
        });

        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addWorkDialog.dismiss();
            }
        });


    }

    public void showDatePicker(CalendarDatePickerDialogFragment.OnDateSetListener onDateSetListener){
        CalendarDatePickerDialogFragment cdp = new CalendarDatePickerDialogFragment()
                .setOnDateSetListener(onDateSetListener)
                .setFirstDayOfWeek(Calendar.SUNDAY);
        cdp.show(MainActivity.fragmentManager, FRAG_TAG_DATE_PICKER);
    }

    public void showTimePicker(RadialTimePickerDialogFragment.OnTimeSetListener onTimeSetListener){
        RadialTimePickerDialogFragment rtpd = new RadialTimePickerDialogFragment()
                .setOnTimeSetListener(onTimeSetListener)
                .setForced12hFormat();
        rtpd.show(MainActivity.fragmentManager, FRAG_TAG_TIME_PICKER);
    }

    @Override
    public void onDateSet(CalendarDatePickerDialogFragment dialog, int year, int monthOfYear, int dayOfMonth) {
        dialogDate.setText(dialog.getResources().getString(R.string.calendar_date_picker_result_values, year, monthOfYear, dayOfMonth));
    }

    @Override
    public void onTimeSet(RadialTimePickerDialogFragment dialog, int hourOfDay, int minute) {
        dialogTime.setText(dialog.getResources().getString(R.string.calendar_time_picker_result_values, hourOfDay, minute));
    }
}
