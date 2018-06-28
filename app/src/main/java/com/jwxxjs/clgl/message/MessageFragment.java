package com.jwxxjs.clgl.message;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jwxxjs.clgl.R;
import com.jwxxjs.clgl.alert.AlertActivity;
import com.jwxxjs.clgl.main.homepage.fragments.category.CategoryAdapter;
import com.jwxxjs.clgl.mvp.MVPBaseFragment;

import butterknife.BindView;

/**
 * MVPPlugin
 *  邮箱 1151934910@qq.com
 */

public class MessageFragment extends MVPBaseFragment<MessageContract.View, MessagePresenter> implements MessageContract.View {
    @BindView(R.id.message_category_list)
    RecyclerView mRecyclerView;


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

        initRecyclerView();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_message;
    }



    private void initRecyclerView(){
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        CategoryAdapter mAdapter = new CategoryAdapter(mRecyclerView);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener((position, holder) -> {
            switch (position) {
                case 0:
                    //报警
                    startActivity(new Intent(getActivity(), AlertActivity.class));
                    break;
                case 1:
                    //违章
                    startActivity(new Intent(getActivity(), AlertActivity.class));
                    break;
                case 2:
                    //行程
                    startActivity(new Intent(getActivity(), AlertActivity.class));
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                default:
                    break;
            }
        });
    }

    @Override
    public void finishCreateView(Bundle state) {

    }
}
