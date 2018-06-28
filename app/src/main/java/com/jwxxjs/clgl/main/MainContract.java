package com.jwxxjs.clgl.main;

import android.content.Context;

import com.jwxxjs.clgl.mvp.BasePresenter;
import com.jwxxjs.clgl.mvp.BaseView;

/**
 * MVPPlugin
 *  邮箱 1151934910@qq.com
 */

public class MainContract {
    interface View extends BaseView {
        void showDrawerlayout();
    }

    interface  Presenter extends BasePresenter<View> {
        
    }
}
