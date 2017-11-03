package com.jwxxjs.clgl.main;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

import com.jwxxjs.clgl.R;
import com.jwxxjs.clgl.car.CarFragment;
import com.jwxxjs.clgl.message.MessageFragment;
import com.jwxxjs.clgl.mvp.MVPBaseActivity;
import com.jwxxjs.clgl.user.UserFragment;

import butterknife.BindView;


/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class MainActivity extends MVPBaseActivity<MainContract.View, MainPresenter> implements MainContract.View {

    //UI控件
    @BindView(R.id.main_tab)
    TabLayout mTabLayout;

    @BindView(R.id.main_viewpager)
    ViewPager mViewPager;

    CarFragment mCarFragment;
    MessageFragment mMessageFragment;
    UserFragment mUserFragment;

    PagerAdapter mPagerAdapter;

    //私有成员变量
    private MainPresenter mMainPresenter;


    //初始化
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    //重写方法
    @NonNull
    @Override
    public MainPresenter createPresenter() {
        mMainPresenter = new MainPresenter();
        return mMainPresenter;
    }

    @Override
    public void initAllMembers(Bundle bundle) {
        initFragments();
    }

    private void initFragments(){

        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.addTab(mTabLayout.newTab());
        mTabLayout.addTab(mTabLayout.newTab());

        if(null == mCarFragment){
            mCarFragment = new CarFragment();
        }
        if(null == mMessageFragment){
            mMessageFragment = new MessageFragment();
        }
        if(null == mUserFragment){
            mUserFragment = new UserFragment();
        }


        mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);

        mTabLayout.getTabAt(0).setText(R.string.tablayout_tab_vehicle).setIcon(R.mipmap.nav_car_sel);
        mTabLayout.getTabAt(1).setText(R.string.tablayout_tab_message).setIcon(R.mipmap.nav_mes_sel);
        mTabLayout.getTabAt(2).setText(R.string.tablayout_tab_user).setIcon(R.mipmap.nav_user_sel);
    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }


    public class PagerAdapter extends FragmentPagerAdapter {
        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    return mCarFragment;
                case 1:
                    return mMessageFragment;
                case 2:
                    return mUserFragment;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
