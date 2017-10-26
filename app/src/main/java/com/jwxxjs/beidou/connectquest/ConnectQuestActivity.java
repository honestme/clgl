package com.jwxxjs.beidou.connectquest;

import android.os.Bundle;
import android.widget.Toast;

import com.jwxxjs.beidou.R;
import com.jwxxjs.beidou.base.BaseActivity;

import butterknife.BindString;

/**
 * Created by Administrator on 2017/10/17 0017.
 *
 * @link
 * @description 蓝牙拦截终端的界面，以弹出式窗口的形式实现。
 */

public class ConnectQuestActivity extends BaseActivity<IConnectQuestView,ConnectQuestPresenter> implements IConnectQuestView {

    @BindString(R.string.connect_quest_bluetooth_not_exist)
    String mBluetoothNotExist;
    @BindString(R.string.connect_quest_bluetooth_is_disabled)
    String mBluetoothIsDisabled;
    @BindString(R.string.connect_quest_turn_on_bluetooth_succeed)
    String mBluetoothTurnOnSucceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void bluetoothDeviceNotExists() {
        Toast.makeText(this,mBluetoothNotExist,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void bluetoothDeviceDisabled() {
        Toast.makeText(this,mBluetoothIsDisabled,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void turnOnBluetoothSucceed() {
        Toast.makeText(this,mBluetoothTurnOnSucceed,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showSearchingProgress() {

    }

    @Override
    public void showAvailableDevices() {

    }
}
