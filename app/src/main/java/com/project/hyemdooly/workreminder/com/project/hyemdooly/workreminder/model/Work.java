package com.project.hyemdooly.workreminder.com.project.hyemdooly.workreminder.model;

import java.util.Date;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by songhyemin on 2016. 9. 30..
 */

public class Work extends RealmObject {

    @PrimaryKey
    private String title;
    private String category;
    private Date date;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}