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

public class RealmTouchData {
    Realm mRealm;
    Context context;

    private static final String TAG = MainActivity.class.getSimpleName();

    public RealmTouchData(Realm realm, Context context){
        mRealm = realm;
        this.context = context;
    }


    private RealmResults<Work> getWorkList(){
        return mRealm.where(Work.class).findAll();
    }

    private void addWorkData(String title, String category, Date date, Time time){

        mRealm.beginTransaction();
        Work work = mRealm.createObject(Work.class);
        work.setTitle(title);
        work.setCategory(category);
        work.setDate(date);
        work.setTime(time);
        mRealm.commitTransaction();
    }

    private void deleteuserData(){
        mRealm.beginTransaction();
        RealmResults<Work> workList = mRealm.where(Work.class).findAll();
        mRealm.commitTransaction();
    }


}
