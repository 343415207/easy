package com.moon.common.base.app;

import android.app.Application;

public abstract class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        AppInitHelper.init(this);
    }
}
