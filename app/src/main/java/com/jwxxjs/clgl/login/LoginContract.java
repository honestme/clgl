package com.jwxxjs.clgl.login;

import android.content.Context;

import com.jwxxjs.clgl.mvp.BasePresenter;
import com.jwxxjs.clgl.mvp.BaseView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class LoginContract {
    interface View extends BaseView {
        public void login();

        public void forgotPassword();

        public void loginFailed(int code);
    }

    interface  Presenter extends BasePresenter<View> {
        public int login(String userName,String password);

        public void forgotPassword();

        public int checkoutInput(String userName);

        public void rememberPassword(String pwd);
    }
}
