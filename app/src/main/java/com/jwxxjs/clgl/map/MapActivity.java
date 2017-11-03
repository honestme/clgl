package com.jwxxjs.clgl.map;


import android.os.Bundle;
import android.support.annotation.NonNull;

import com.jwxxjs.clgl.mvp.MVPBaseActivity;


/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class MapActivity extends MVPBaseActivity<MapContract.View, MapPresenter> implements MapContract.View {
    @NonNull
    @Override
    public MapPresenter createPresenter() {
        return null;
    }

    @Override
    protected void initAllMembers(Bundle bundle) {

    }

    @Override
    protected int getContentViewId() {
        return 0;
    }
}
