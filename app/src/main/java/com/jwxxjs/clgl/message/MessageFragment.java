package com.jwxxjs.clgl.message;


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

public class MessageFragment extends MVPBaseFragment<MessageContract.View, MessagePresenter> implements MessageContract.View {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @NonNull
    @Override
    public MessagePresenter createPresenter() {
        return new MessagePresenter();
    }

    @Override
    protected void initAllMembers(Bundle bundle) {

    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_message;
    }
}
