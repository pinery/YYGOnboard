package com.cimcitech.yygonboard;

import android.app.Application;

import com.cimcitech.yygonboard.utils.Config;

/**
 * Created by cimcitech on 2018/4/16.
 */

public class ApkApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        Config.CONTEXT = getApplicationContext();
    }
}
