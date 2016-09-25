package com.project.hyemdooly.workreminder;

/**
 * Created by songhyemin on 2016. 9. 25..
 */

public class dataSetClass {
    String workTitle;
    String workCategory;
    String hour;
    String minute;
    String year;
    String month;
    String day;

    public dataSetClass(String title, String category, String hour, String minute, String year, String month, String day){
        this.workTitle = title;
        this.workCategory = category;
        this.hour = hour;
        this.minute = minute;
        this.year = year;
        this.month = month;
        this.day = day;
    }

}
