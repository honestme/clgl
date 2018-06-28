package com.jwxxjs.clgl.login;

import android.content.Context;

import com.jwxxjs.clgl.mvp.BasePresenter;
import com.jwxxjs.clgl.mvp.BaseView;

import java.util.List;

/**
 * MVPPlugin
 *  邮箱 1151934910@qq.com
 */

public class LoginContract {
    interface View extends BaseView {
        void login();

        void loginSucceed();

        void forgotPassword();

        void loginFailed();

        void showLoginProgress();

        void hideLoginProgress();


    }

    interface  Presenter extends BasePresenter<View> {
        int login(String userName, String password);

        void forgotPassword();

        void rememberPassword(String pwd);

        void accountVerify(String userName, String password);

        List<UserModel> getAccountData();
    }
}
