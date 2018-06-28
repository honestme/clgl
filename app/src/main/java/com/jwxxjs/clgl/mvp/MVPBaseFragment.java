package com.jwxxjs.clgl.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby3.mvp.MvpFragment;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * MVPPlugin
 *  邮箱 1151934910@qq.com
 */

public abstract class MVPBaseFragment<V extends BaseView,P extends com.jwxxjs.clgl.mvp.BasePresenterImpl<V>> extends MvpFragment<V,P> implements BaseView{

    //私有成员变量
    private Unbinder mUnbinder;
    private FragmentActivity mFragmentActivity;
    //初始化是否完成
    private boolean isPrepared;
    //fragment是否可见
    private boolean isVisible;
    private View parentView;

    //初始化
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        parentView = inflater.inflate(getContentViewId(),container,false);
        mFragmentActivity = this.getActivity();
        return parentView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mUnbinder = ButterKnife.bind(this,view);
        initAllMembers(savedInstanceState);
        finishCreateView(savedInstanceState);
    }

    @Override




    public void onDestroyView() {
        super.onDestroyView();
        mUnbinder.unbind();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mFragmentActivity = (FragmentActivity)activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        this.mFragmentActivity = null;
    }

    //抽象函数
    @NonNull
    public abstract P createPresenter();

    public abstract void finishCreateView(Bundle state);

    protected abstract void initAllMembers(Bundle bundle);

    protected abstract int getContentViewId();


}

