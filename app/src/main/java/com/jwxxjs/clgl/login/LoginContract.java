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
        public void logIn();
    }

    interface  Presenter extends BasePresenter<View> {
        
    }
}
