package com.example.rxjava_map.util;

import android.app.Application;

import com.example.rxjava_map.CrashHandler;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LogcatHelper.getInstance(this).start();
        CrashHandler crashHandler = new CrashHandler();
        Thread.setDefaultUncaughtExceptionHandler(crashHandler);
    }
}
