package com.project.hyemdooly.workreminder.com.project.hyemdooly.workreminder.front;

import android.content.Context;

import com.project.hyemdooly.workreminder.com.project.hyemdooly.workreminder.model.Work;

import java.util.Date;

import io.realm.Realm;
import io.realm.RealmResults;



/**
 * Created by songhyemin on 2016. 10. 16..
 */

public class RealmTouchData {
    Realm mRealm = Realm.getDefaultInstance();
    Context context;

    private static final String TAG = MainActivity.class.getSimpleName();

    public RealmTouchData(Context context){
        this.context = context;
    }


    public RealmResults<Work> getWorkList(){
        return mRealm.where(Work.class).findAll();
    }


    public void addWorkData(String title, String category, Date date){
        mRealm.beginTransaction();
        Work work = mRealm.createObject(Work.class);
        work.setTitle(title);
        work.setCategory(category);
        work.setDate(date);
        mRealm.commitTransaction();
    }

    public void deleteuserData(String mTitle){
        mRealm.beginTransaction();
        RealmResults<Work> workList = mRealm.where(Work.class).equalTo("title", mTitle).findAll();
        workList.deleteAllFromRealm();
        mRealm.commitTransaction();
    }

    public void searchWorkDataWithTitle(){

    }

    public void searchWorkDataWithCategory(){

    }

}
