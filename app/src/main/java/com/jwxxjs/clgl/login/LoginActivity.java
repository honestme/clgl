package com.jwxxjs.clgl.login;


import android.accounts.NetworkErrorException;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toolbar;

import com.alibaba.fastjson.serializer.ToStringSerializer;
import com.jwxxjs.clgl.R;
import com.jwxxjs.clgl.main.MainActivity;
import com.jwxxjs.clgl.mvp.MVPBaseActivity;
import com.jwxxjs.clgl.utils.ConstantUtils;
import com.jwxxjs.clgl.utils.PreferenceUtils;
import com.jwxxjs.clgl.utils.ToastUtils;

import java.io.IOException;

import butterknife.BindView;
import butterknife.OnClick;
import me.zhanghai.android.materialprogressbar.MaterialProgressBar;


/**
 * MVPPlugin
 *  邮箱 1151934910@qq.com
 */

public class LoginActivity extends MVPBaseActivity<LoginContract.View, LoginPresenter> implements LoginContract.View {

    //UI控件
    @NonNull@BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.delete_username)
    ImageView mImageView;

    @NonNull
    @BindView(R.id.btn_commit)
    Button mBtnLogIn;
    @NonNull @BindView(R.id.edit_user)
    EditText mEditTextUser;
    @NonNull @BindView(R.id.edit_pwd) EditText mEditTextPwd;
    @NonNull @BindView(R.id.login_progress)
    MaterialProgressBar mProgressBar;

    private LoginPresenter mLoginPresenter;


    //初始化
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initAllMembers(Bundle bundle) {

        mEditTextUser.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    //事件响应
    @NonNull @OnClick(R.id.btn_commit) @Override public void login() {
        final String userName = mEditTextUser.getText().toString();
        final String password = mEditTextPwd.getText().toString();


        if(TextUtils.isEmpty(userName)){
            ToastUtils.shortToast(R.string.username_cannot_be_empty);
        }
        if(TextUtils.isEmpty(password)){
            ToastUtils.shortToast(R.string.password_cannot_be_empty);
        }

        PreferenceUtils.put(ConstantUtils.LOGIN_KEY,true);

        showLoginProgress();

        final Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                if(msg.what != -1){
                    loginSucceed();
                }else{
                    loginFailed();
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


    @Override
    public void loginSucceed() {
        hideLoginProgress();
        Intent intentLogIn = new Intent();
        ComponentName componentName = new ComponentName(this, MainActivity.class);
        intentLogIn.setComponent(componentName);
        startActivity(intentLogIn);
    }

    @Override
    public void showLoginProgress() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoginProgress() {
        mProgressBar.setVisibility(View.INVISIBLE);
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
    public void loginFailed() {
        hideLoginProgress();

        final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        alertDialog.setMessage("您输入的账号名或密码有误");
        alertDialog.setCancelable(true);
        alertDialog.setTitle("提示");

        alertDialog.setButton(DialogInterface.BUTTON_POSITIVE,"重试",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });

        alertDialog.setButton(DialogInterface.BUTTON_NEGATIVE,"取消",new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.dismiss();
            }
        });



    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_login;
    }

    @Override
    public void initToolbar() {

    }
}
