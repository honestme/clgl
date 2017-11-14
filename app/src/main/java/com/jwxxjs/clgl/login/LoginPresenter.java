package com.jwxxjs.clgl.login;

import android.content.Context;

import com.jwxxjs.clgl.mvp.BasePresenterImpl;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class LoginPresenter extends BasePresenterImpl<LoginContract.View> implements LoginContract.Presenter{
    UserModel mUserModel;


    @Override
    public int login(String userName, String password) {
        int ret = -1;
        if(userName.equals("admin") && password.equals("admin")){
            ret = 0;
        }
        return ret;
    }


    @Override
    public int checkoutInput(String userName) {
        return 0;
    }

    @Override
    public void rememberPassword(String pwd) {

    }

    @Override
    public void forgotPassword() {

    }
}
