package com.project.hyemdooly.workreminder.front;

import java.util.Date;

/**
 * Created by songhyemin on 2016. 11. 9..
 */

public class DateConvertToDateOrTime {

    private java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat("yy-MM-dd");
    private java.text.SimpleDateFormat timeFormat = new java.text.SimpleDateFormat("HH:mm");

    public DateConvertToDateOrTime(){
    }


    public String getTime(Date date){
        return timeFormat.format(date);
    }

    public String getDate(Date date){
        return dateFormat.format(date);
    }

}
