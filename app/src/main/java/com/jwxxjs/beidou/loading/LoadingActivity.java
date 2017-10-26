package com.jwxxjs.beidou.loading;

import android.support.annotation.NonNull;

import com.jwxxjs.beidou.base.BaseActivity;
import com.jwxxjs.beidou.login.ILoginView;


/**
 * Created by Administrator on 2017/10/13 0013.
 */

public class LoadingActivity extends BaseActivity<ILoadingView,LoadingPresenter> implements ILoginView{
    @NonNull
    @Override
    public LoadingPresenter createPresenter() {
        return new LoadingPresenter();
    }
}
