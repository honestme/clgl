package com.jwxxjs.beidou.base;

import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby3.mvp.MvpActivity;

/**
 * Created by Administrator on 2017/10/16 0016.
 */

public class BaseActivity<V extends IBaseView,P extends BasePresenter<V>> extends MvpActivity<V,P> implements IBaseView {
    @NonNull
    @Override
    public P createPresenter() {
        return null;
    }
}
