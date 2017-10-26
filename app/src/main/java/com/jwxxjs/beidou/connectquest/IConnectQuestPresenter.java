package com.jwxxjs.beidou.connectquest;

import com.jwxxjs.beidou.base.IBasePresenter;

/**
 * Created by Administrator on 2017/10/17 0017.
 *
 * @link
 * @description 这是蓝牙连接模块中的presenter层，主要实现了检测蓝牙，开启蓝牙，搜索终端设备，连接终端设备等方
 * 法。
 */

public interface IConnectQuestPresenter extends IBasePresenter<IConnectQuestView> {

    public int checkBluetoothStatus();

    public void enableBluetooth();

    public void showAvailableDevices();


}
