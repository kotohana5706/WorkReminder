package com.project.hyemdooly.workreminder.com.project.hyemdooly.workreminder.front;

import android.content.Context;
import android.util.Log;

import com.project.hyemdooly.workreminder.com.project.hyemdooly.workreminder.model.Work;

import java.sql.Time;
import java.util.Date;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by songhyemin on 2016. 10. 16..
 */

public class TouchData{
    Realm mRealm;
    Context context;

    public TouchData(Realm realm, Context context){
        mRealm = realm;
        this.context = context;
    }

    public void init(){
        mRealm = Realm.getInstance(context.Configuration);
        RealmResults<Work> workList = getWorkList();
        Log.i(TAG, "workList Size : "+ workList.size());


    }

    private RealmResults<Work> getWorkList(){
        return mRealm.where(Work.class).findAll();
    }

    private void insertWorkData(String title, String category, Date date, Time time){

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
        workList.remove();
        mRealm.commitTransaction();
    }


}
