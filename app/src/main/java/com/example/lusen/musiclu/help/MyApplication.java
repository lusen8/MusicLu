package com.example.lusen.musiclu.help;

import android.app.Application;
import android.content.Context;

/**
 * Created by wentai on 17-4-23.
 */

public class MyApplication extends Application {

    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }

}
