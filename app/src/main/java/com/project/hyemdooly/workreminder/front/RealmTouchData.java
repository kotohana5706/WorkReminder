package com.project.hyemdooly.workreminder.front;

import android.content.Context;

import com.project.hyemdooly.workreminder.model.Work;

import java.util.Calendar;

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


    public void addWorkData(String title, String category, Calendar date){

        mRealm.beginTransaction();
//        Work work = mRealm.createObject(Work.class, new Work());
//        work.setTitle(title);
//        work.setCategory(category);
//        work.setDate(date.getTime());

        Work work = new Work();
        work.setId(getNextId());
        work.setTitle(title);
        work.setCategory(category);
        work.setDate(date.getTime());
        mRealm.copyToRealm(work);
        mRealm.commitTransaction();

    }

    public void deleteuserData(String title, String category){
        mRealm.beginTransaction();
        RealmResults<Work> workList = mRealm.where(Work.class).equalTo("title", title).equalTo("category", category).findAll();
        workList.deleteAllFromRealm();
        mRealm.commitTransaction();
    }

    public void searchWorkDataWithTitle(){

    }

    public void searchWorkDataWithCategory(){

    }

    public long getNextId(){
        try{
            return mRealm.where(Work.class).max("id").intValue()+1;
        }catch(Exception e){
            return 0;
        }

    }

}
