package com.jwxxjs.clgl.loading;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.jwxxjs.clgl.base.BaseActivity;
import com.jwxxjs.clgl.login.ILoginView;


/**
 * Created by Administrator on 2017/10/13 0013.
 */

public class LoadingActivity extends BaseActivity<ILoadingView,LoadingPresenter> implements ILoadingView {
    @Override
    protected void initAllMembers(Bundle bundle) {

    }

    @Override
    protected int getContentViewId() {
        return 0;
    }

    @NonNull
    @Override
    public LoadingPresenter createPresenter() {
        return new LoadingPresenter();
    }
}
