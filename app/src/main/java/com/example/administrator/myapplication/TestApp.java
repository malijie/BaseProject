package com.example.administrator.myapplication;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.vic.base.utils.Logger;
import com.vic.base.utils.Profile;

/**
 * Created by Administrator on 2016/6/25.
 */
public class TestApp extends Application{
    public static Context sContext = null;
    @Override
    public void onCreate() {
        super.onCreate();
        sContext = getApplicationContext();
        Profile.initProfile(sContext);
        Logger.setLogSwitch(true);
    }
}
