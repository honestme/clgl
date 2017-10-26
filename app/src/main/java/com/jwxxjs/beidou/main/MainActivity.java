package com.jwxxjs.beidou.main;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.jwxxjs.beidou.R;
import com.jwxxjs.beidou.base.BaseActivity;

/**
 * Created by Administrator on 2017/10/13 0013.
 */

public class MainActivity extends BaseActivity<IMainView,MainPresenter> implements IMainView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return null;
    }


    @Override
    public void showBluetoothConnectDialog() {

    }

    @Override
    public void showBluetoothDeviceList() {

    }
}
