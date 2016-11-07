package com.project.hyemdooly.workreminder.com.project.hyemdooly.workreminder.front;

import android.content.Context;

import com.project.hyemdooly.workreminder.com.project.hyemdooly.workreminder.model.Work;

import java.util.Date;

import io.realm.OrderedRealmCollection;
import io.realm.Realm;
import io.realm.RealmResults;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

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


    private RealmResults<Work> getWorkList(){
        return mRealm.where(Work.class).findAll();
    }


    private void addWorkData(String title, String category, Date date){
        mRealm.beginTransaction();
        Work work = mRealm.createObject(Work.class);
        work.setTitle(title);
        work.setCategory(category);
        work.setDate(date);
        mRealm.commitTransaction();
    }

    private void deleteuserData(int position, OrderedRealmCollection<Work> adapterData){
        mRealm.beginTransaction();
        RealmResults<Work> workList = mRealm.where(Work.class).equalTo().findAll();
        mRealm.commitTransaction();
    }


}
