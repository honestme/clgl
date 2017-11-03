package com.jwxxjs.clgl.login;


import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.Button;
import android.widget.EditText;

import com.jwxxjs.clgl.R;
import com.jwxxjs.clgl.main.MainActivity;
import com.jwxxjs.clgl.mvp.MVPBaseActivity;

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

    //初始化
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void initAllMembers(Bundle bundle) {

    }

    //事件响应
    @NonNull @OnClick(R.id.btn_commit) @Override public void logIn() {
        Intent intentLogIn = new Intent();
        ComponentName componentName = new ComponentName(this, MainActivity.class);
        intentLogIn.setComponent(componentName);
        startActivity(intentLogIn);
    }



    //重载方法
    @NonNull
    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_login;
    }
}
