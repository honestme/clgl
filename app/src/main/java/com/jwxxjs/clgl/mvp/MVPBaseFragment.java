package com.jwxxjs.clgl.mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby3.mvp.MvpFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public abstract class MVPBaseFragment<V extends BaseView,P extends com.jwxxjs.clgl.mvp.BasePresenterImpl<V>> extends MvpFragment<V,P> implements BaseView{

    //私有成员变量
    private Unbinder mUnbinder;

    //初始化
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getContentViewId(),container,false);
        mUnbinder = ButterKnife.bind(this,view);
        initAllMembers(savedInstanceState);
        return view;
    }

    //抽象函数
    @NonNull
    public abstract P createPresenter();

    protected abstract void initAllMembers(Bundle bundle);
    protected abstract int getContentViewId();
}

