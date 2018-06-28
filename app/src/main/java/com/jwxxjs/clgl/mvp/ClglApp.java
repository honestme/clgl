package com.jwxxjs.clgl.mvp;

import android.app.Application;

import com.baidu.mapapi.SDKInitializer;

/**
 * Created by zcl on 2018/1/10.
 *
 * @link
 * @description
 */

public class ClglApp extends Application{
    public static ClglApp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        //?
        mInstance = this;
        init();
    }

    private void init(){

        SDKInitializer.initialize(this);
    }

    public static ClglApp getInstance(){
        return mInstance;
    }
}
