package com.jwxxjs.clgl.mvp;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;


/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class BasePresenterImpl<V extends BaseView> extends MvpBasePresenter<V> implements BasePresenter<V> {
    protected V mView;
    @Override
    public void attachView(V view) {
        mView=view;
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
    }
}
