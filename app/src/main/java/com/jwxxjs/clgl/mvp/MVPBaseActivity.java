package com.jwxxjs.clgl.mvp;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;

import com.hannesdorfmann.mosby3.mvp.MvpActivity;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * MVPPlugin
 *  邮箱 1151934910@qq.com
 */
public abstract class MVPBaseActivity<V extends BaseView,P extends com.jwxxjs.clgl.mvp.BasePresenterImpl<V>> extends MvpActivity<V,P> implements BaseView {
    private Unbinder mUnbinder;
    //初始化
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewId());
        mUnbinder = ButterKnife.bind(this);
        initAllMembers(savedInstanceState);
        initToolbar();
        ActivityCollector.addActivity(this);

        Log.d("BaseActivity",getClass().getSimpleName());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
        ActivityCollector.removeActivity(this);
    }

    //抽象函数
    @NonNull
    public abstract P createPresenter();

    protected abstract void initAllMembers(Bundle bundle);


    protected abstract int getContentViewId();


    public abstract void initToolbar();
}

