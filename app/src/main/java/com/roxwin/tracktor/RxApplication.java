package com.roxwin.tracktor;

import android.content.Context;
import android.support.multidex.MultiDexApplication;

/**
 * Created by phuctran on 11/5/16.
 */

public class RxApplication extends MultiDexApplication {
    private static Context sContext;


    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }

    public static Context getContext() {
        return sContext;
    }
}
