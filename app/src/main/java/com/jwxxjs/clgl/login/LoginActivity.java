package com.jwxxjs.clgl.login;


import android.accounts.NetworkErrorException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.widget.Button;
import android.widget.EditText;

import com.jwxxjs.clgl.R;
import com.jwxxjs.clgl.main.MainActivity;
import com.jwxxjs.clgl.mvp.MVPBaseActivity;

import java.io.IOException;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class LoginActivity extends MVPBaseActivity<LoginContract.View, LoginPresenter> implements LoginContract.View {

    //UI控件
    @NonNull
    @BindView(R.id.btn_commit)
    Button mBtnLogIn;
    @NonNull @BindView(R.id.edit_user)
    EditText mEditTextUser;
    @NonNull @BindView(R.id.edit_pwd) EditText mEditTextPwd;

    private LoginPresenter mLoginPresenter;


    //初始化
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initAllMembers(Bundle bundle) {

    }

    //事件响应
    @NonNull @OnClick(R.id.btn_commit) @Override public void login() {
        final String userName = mEditTextUser.getText().toString();
        final String password = mEditTextPwd.getText().toString();
        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if(msg.what == 0){
                    Intent intentLogIn = new Intent();
                    ComponentName componentName = new ComponentName(getApplicationContext(), MainActivity.class);
                    intentLogIn.setComponent(componentName);
                    startActivity(intentLogIn);
                }else{
                    loginFailed(msg.what);
                }
            }
        };


        new Thread(){
            @Override
            public void run() {
                int ret = -1;
                try{
                    ret = mLoginPresenter.login(userName,password);
                }catch (Exception e){
                    e.printStackTrace();
                }
                Message message = new Message();
                message.what = ret;
                handler.sendMessage(message);
            }
        }.start();
    }



    //重写方法
    @NonNull
    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }


    @Override
    public void forgotPassword() {

    }

    @Override
    public void loginFailed(int code) {
        switch (code){
            case -1:
                break;
            case 1:
                break;
            case 2:
                break;
        }

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_login_backup;
    }
}
