package com.jdurieu.reddevils.app;


import android.app.Application;

import com.jdurieu.reddevils.app.network.FootService;

public class FootApplication extends Application {

    private FootService mFootService;

    @Override
    public void onCreate() {
        super.onCreate();

        mFootService = new FootService(this);
    }

    public FootService getFootService() {
        return mFootService;
    }
}
