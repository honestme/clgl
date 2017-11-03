package com.jwxxjs.clgl.main;

import android.content.Context;

import com.jwxxjs.clgl.mvp.BasePresenter;
import com.jwxxjs.clgl.mvp.BaseView;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class MainContract {
    interface View extends BaseView {
        
    }

    interface  Presenter extends BasePresenter<View> {
        
    }
}
