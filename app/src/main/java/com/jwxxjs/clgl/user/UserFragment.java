package com.jwxxjs.clgl.user;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jwxxjs.clgl.R;
import com.jwxxjs.clgl.mvp.MVPBaseFragment;

/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class UserFragment extends MVPBaseFragment<UserContract.View, UserPresenter> implements UserContract.View {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @NonNull
    @Override
    public UserPresenter createPresenter() {
        return new UserPresenter();
    }

    @Override
    protected void initAllMembers(Bundle bundle) {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_personal;
    }
}
