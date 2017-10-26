package com.jwxxjs.beidou.connectquest;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.clj.fastble.BleManager;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.jwxxjs.beidou.R;
import com.jwxxjs.beidou.base.BasePresenter;

import butterknife.BindString;
import butterknife.BindView;



/**
 * Created by Administrator on 2017/10/17 0017.
 *
 * @link
 * @description
 */

public class ConnectQuestPresenter extends BasePresenter<IConnectQuestView> implements IConnectQuestPresenter{

    public final int BLUETOOTH_NOT_EXIST = 0;
    public final int BLUETOOTH_IS_DISABLED = 1;
    public final int BLUETOOTH_IS_ENABLED = 2;



    private ConnectQuestActivity mConnectQuestActivity = (ConnectQuestActivity)getView();


    @Override
    public int checkBluetoothStatus() {
        int retCode = 0;

        BluetoothManager bluetoothManager = (BluetoothManager) mConnectQuestActivity.getSystemService(Context.BLUETOOTH_SERVICE);
        BluetoothAdapter bluetoothAdapter = bluetoothManager.getAdapter();

        if (null == bluetoothAdapter){
            retCode = BLUETOOTH_NOT_EXIST;
        }else if(!bluetoothAdapter.isEnabled()){
            retCode = BLUETOOTH_IS_DISABLED;
        }else {
            retCode = BLUETOOTH_IS_ENABLED;
        }

        return retCode;



    }


    @Override
    public void enableBluetooth() {
        Intent turnOnBluetooth = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        mConnectQuestActivity.startActivityForResult(turnOnBluetooth,0);
    }

    @Override
    public void showAvailableDevices() {

    }
}
