package com.citimate;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

public class MyApplication extends MultiDexApplication {

    @Override
    public void onCreate() {
        super.onCreate();

        FontsOverride.setDefaultFont(this, "MONOSPACE", "Roboto-Regular.ttf");
        FontsOverride.setDefaultFont(this, "SERIF", "Roboto-Medium.ttf");
        FontsOverride.setDefaultFont(this, "SANS_SERIF", "Roboto-Light.ttf");
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }
}
