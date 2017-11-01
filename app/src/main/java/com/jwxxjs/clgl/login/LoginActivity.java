package com.jwxxjs.clgl.login;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;

import com.hcb.clgl.R;
import com.jwxxjs.clgl.base.BaseActivity;
import com.jwxxjs.clgl.main.MainActivity;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017/10/16 0016.
 */

public class LoginActivity extends BaseActivity<ILoginView,LoginPresenter> implements ILoginView{

    //UI控件
    @NonNull @BindView(R.id.btn_commit) Button mBtnLogIn;

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
