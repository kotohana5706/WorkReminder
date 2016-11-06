package com.project.hyemdooly.workreminder.com.project.hyemdooly.workreminder.front;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by songhyemin on 2016. 11. 6..
 */

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        // The Realm file will be located in Context.getFilesDir() with name "default.realm"
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("data.realm").build();
        Realm.setDefaultConfiguration(config);
    }
}