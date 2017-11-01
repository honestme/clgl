package com.jwxxjs.clgl.main;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.hcb.clgl.R;
import com.jwxxjs.clgl.base.BaseActivity;
import com.ycl.tabview.library.TabView;
import com.ycl.tabview.library.TabViewChild;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/10/13 0013.
 */

public class MainActivity extends BaseActivity<IMainView,MainPresenter> implements IMainView {
    //UI控件
    @BindView(R.id.tabview)
    TabView mTabView;

    //初始化
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    //重写方法
    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initAllMembers(Bundle bundle) {
        //填充tabview内容
        List<TabViewChild> tabViewChildList = new ArrayList<>();
        TabViewChild tabViewChild01=new TabViewChild(R.mipmap.nav_car_sel,R.mipmap.nav_car_nor,"车辆", null);
        TabViewChild tabViewChild02=new TabViewChild(R.mipmap.nav_mes_sel,R.mipmap.nav_mes_nor,"信息", null);
        TabViewChild tabViewChild03=new TabViewChild(R.mipmap.nav_user_sel,R.mipmap.nav_user_nor,"用户", null);
        tabViewChildList.add(tabViewChild01);
        tabViewChildList.add(tabViewChild02);
        tabViewChildList.add(tabViewChild03);
        mTabView.setTabViewChild(tabViewChildList,getSupportFragmentManager());

    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }
}
