package com.project.hyemdooly.workreminder.com.project.hyemdooly.workreminder.front;

import android.content.Context;

import com.project.hyemdooly.workreminder.com.project.hyemdooly.workreminder.model.Work;

import java.sql.Time;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by songhyemin on 2016. 10. 16..
 */

public class TouchData{
    Realm realm;
    Context context;

    public TouchData(Realm realm, Context context){
        this.realm = realm;
        this.context = context;
    }

    public void addData(final String title, final Date date, final Time time){
        Work mWork = null;
        mWork.setTitle(title);
        mWork.setDate(date);
        mWork.setTime(time);

        realm.beginTransaction();
        realm.copyToRealm(mWork);
        realm.commitTransaction();
        realm.close();
    }

    public void deleteData(){

    }

    public void editData(String title, Date date, Time time){


    }

    public void sortData(){
        RealmResults<Work> results = realm.where(Work.class).findAll();
        results = results.sort("date");
    }
}
