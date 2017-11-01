package com.jwxxjs.clgl.base;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby3.mvp.MvpActivity;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/10/16 0016.
 */

public abstract class BaseActivity<V extends IBaseView,P extends BasePresenter<V>> extends MvpActivity<V,P> implements IBaseView {
    //初始化
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        ButterKnife.bind(this);
        initAllMembers(savedInstanceState);
    }

    //抽象函数
    @NonNull public abstract P createPresenter();

    protected abstract void initAllMembers(Bundle bundle);
    protected abstract int getContentViewId();
}
