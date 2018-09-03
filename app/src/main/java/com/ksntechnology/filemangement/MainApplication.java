package com.ksntechnology.filemangement;

import android.app.Application;

import com.ksntechnology.filemangement.manager.Contextor;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Contextor.getInstance().init(getApplicationContext());
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
