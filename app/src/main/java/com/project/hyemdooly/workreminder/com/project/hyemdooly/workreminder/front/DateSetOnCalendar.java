package com.project.hyemdooly.workreminder.com.project.hyemdooly.workreminder.front;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by songhyemin on 2016. 11. 8..
 */

public class DateSetOnCalendar{
    int year;
    int month;
    int date;
    int hrs;
    int min;

    public DateSetOnCalendar(){
    }

    public void setDate(int mYear, int mMonth, int mDate){
        year = mYear;
        month = mMonth;
        date = mDate;

    }

    public void setTime(int mHrs, int mMin){
        hrs = mHrs;
        min = mMin;
    }

    public Calendar getCalendar(){
        Calendar calendar = new GregorianCalendar();
        calendar.set(year, month, date, hrs, min);
        return calendar;
    }


}