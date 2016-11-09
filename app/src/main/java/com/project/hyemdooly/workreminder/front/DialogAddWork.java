package com.project.hyemdooly.workreminder.front;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.codetroopers.betterpickers.calendardatepicker.CalendarDatePickerDialogFragment;
import com.codetroopers.betterpickers.radialtimepicker.RadialTimePickerDialogFragment;
import com.project.hyemdooly.workreminder.R;

import java.util.Calendar;

import static com.project.hyemdooly.workreminder.front.MainActivity.context;

public class DialogAddWork extends AppCompatActivity implements CalendarDatePickerDialogFragment.OnDateSetListener, RadialTimePickerDialogFragment.OnTimeSetListener {

    private EditText dialogDate;
    private EditText dialogTime;
    private EditText dialogCategory;
    private EditText dialogTitle;
    private Button buttonOk;
    private Button buttonCancel;
    private static final String FRAG_TAG_DATE_PICKER = "Select Date";
    private static final String FRAG_TAG_TIME_PICKER = "Select Time";
    private ListViewAdapter adapter;
    private RealmTouchData controller;
    private DateSetOnCalendar setOnCalendar = new DateSetOnCalendar();

    public DialogAddWork(ListViewAdapter adapter, RealmTouchData controller){
        this.adapter = adapter;
        this.controller = controller;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void showDialog(View v){

        final AlertDialog addWorkDialog = new AlertDialog.Builder(context).create();
        addWorkDialog.setView(v);
        addWorkDialog.show();

        dialogTime = (EditText) v.findViewById(R.id.dialog_time);
        dialogDate = (EditText) v.findViewById(R.id.dialog_date);
        dialogTitle = (EditText) v.findViewById(R.id.dialog_title);
        dialogCategory = (EditText) v.findViewById(R.id.dialog_category);
        buttonOk = (Button) v.findViewById(R.id.dialog_ok_button);
        buttonCancel = (Button) v.findViewById(R.id.dialog_cancel_button); // 알맞은 상자에서 id를 찾아줘야함

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
                // save data
                // change Update
                String mTitle = dialogTitle.getText().toString();
                String mCategory = dialogCategory.getText().toString();
                Calendar mDate = setOnCalendar.getCalendar();
                // Calendar.set(year + 1900, month, date, hrs, min)

                controller.addWorkData(mTitle, mCategory, mDate);

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
        dialogDate.setText(dialog.getResources().getString(R.string.calendar_date_picker_result_values, year, monthOfYear+1, dayOfMonth));
        setOnCalendar.setDate(year, monthOfYear+1, dayOfMonth);
    }

    @Override
    public void onTimeSet(RadialTimePickerDialogFragment dialog, int hourOfDay, int minute) {
        dialogTime.setText(dialog.getResources().getString(R.string.calendar_time_picker_result_values, hourOfDay, minute));
        setOnCalendar.setTime(hourOfDay, minute);
    }

}
