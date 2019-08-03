package com.c4f.demo_vnpt;

import android.app.Application;

public class VNPTApplication extends Application  {
    private static VNPTApplication app = null;

    @Override
    public void onCreate() {
        super.onCreate();

        app = this;
    }

    public static VNPTApplication getApp() {
        return app;
    }
}
