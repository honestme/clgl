package com.jwxxjs.beidou.connectquest;

import com.jwxxjs.beidou.base.IBaseView;

/**
 * Created by Administrator on 2017/10/17 0017.
 *
 * @link
 * @description
 */

public interface IConnectQuestView extends IBaseView {

    public void bluetoothDeviceNotExists();

    public void bluetoothDeviceDisabled();

    public void turnOnBluetoothSucceed();

    public void showSearchingProgress();

    public void showAvailableDevices();


}
