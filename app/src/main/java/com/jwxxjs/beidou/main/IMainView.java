package com.jwxxjs.beidou.main;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.jwxxjs.beidou.base.IBaseView;

/**
 * Created by Administrator on 2017/10/13 0013.
 */

public interface IMainView extends IBaseView {

    public void showBluetoothConnectDialog();

    public void showBluetoothDeviceList();
}
