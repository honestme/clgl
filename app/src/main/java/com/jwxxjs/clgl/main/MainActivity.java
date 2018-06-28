package com.jwxxjs.clgl.main;



import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jwxxjs.clgl.R;
import com.jwxxjs.clgl.main.homepage.HomepageFragment;
import com.jwxxjs.clgl.main.homepage.fragments.map.MapFragment;
import com.jwxxjs.clgl.main.homepage.fragments.report.ReportFragment;
import com.jwxxjs.clgl.main.homepage.fragments.report.ReportPresenter;
import com.jwxxjs.clgl.mvp.MVPBaseActivity;
import com.jwxxjs.clgl.setting.SettingActivity;
import com.jwxxjs.clgl.utils.ConstantUtils;
import com.jwxxjs.clgl.utils.PreferenceUtils;
import com.jwxxjs.clgl.utils.ToastUtils;
import com.jwxxjs.clgl.widget.CircleImageView;


import butterknife.BindView;


/**
 * MVPPlugin
 *  邮箱 1151934910@qq.com
 */

public class MainActivity extends MVPBaseActivity<MainContract.View, MainPresenter> implements MainContract.View,NavigationView.OnNavigationItemSelectedListener {
    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;
    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;



    private Fragment[] fragments;
    private int mCurrentTabIndex;
    private int mCurrentMenuIndex;
    private long mExitTime;
    private HomepageFragment mHomePageFragment;
    private MapFragment mMapFragment;
    private ReportFragment mReportFragment;


    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initAllMembers(Bundle bundle) {
        initFragments();
        initNavigationView();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void initToolbar() {

    }

    private void initFragments(){
        mHomePageFragment = new HomepageFragment();
        mReportFragment = new ReportFragment();
        mMapFragment = new MapFragment();
        fragments = new Fragment[]{
                mHomePageFragment,
                mMapFragment,
                mReportFragment,

        };
        // 添加显示第一个fragment
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, mHomePageFragment)
                .show(mHomePageFragment).commit();

    }

    private void initNavigationView(){
        mNavigationView.setNavigationItemSelectedListener(this);
        View headerView = mNavigationView.getHeaderView(0);
        CircleImageView mUserAvatarView = headerView.findViewById(R.id.user_avatar_view);
        TextView mUserName =  headerView.findViewById(R.id.user_name);
        TextView mUserSign =  headerView.findViewById(R.id.user_other_info);
        //设置头像
        mUserAvatarView.setImageResource(R.drawable.btg_icon_user_normal);
        //设置用户名 签名
        mUserName.setText(PreferenceUtils.get("username","admin"));
        mUserSign.setText(PreferenceUtils.get("usersign","admin"));

    }

    @Override
    public void showDrawerlayout() {

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        mDrawerLayout.closeDrawer(Gravity.START);
        switch (item.getItemId()){
            case R.id.item_home:
                switchFragmentByIndex(0);
                break;
            case R.id.item_device_online:
                break;
            case R.id.item_personal_info:
                break;
            case R.id.item_vehicle_info:
                break;
            case R.id.item_vehicle_track:
                break;
            case R.id.item_setting:
                startActivity(new Intent(this, SettingActivity.class));
                break;
        }

        return false;
    }

    private void switchFragmentByIndex(int index){
        mCurrentMenuIndex = index;
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

        if(!fragments[index].isAdded()){
            ft.add(R.id.container,fragments[index]);
        }
        ft.show(fragments[index]).commit();

    }

    public void toggleDrawer() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            mDrawerLayout.openDrawer(GravityCompat.START);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (mDrawerLayout.isDrawerOpen(mDrawerLayout.getChildAt(1))) {
                mDrawerLayout.closeDrawers();
            } else {
                if (mHomePageFragment != null) {


                } else {
                    exitApp();
                }
            }
        }
        return true;
    }

    private void exitApp() {
        if (System.currentTimeMillis() - mExitTime > 2000) {
            ToastUtils.shortToast("再按一次退出");
            mExitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }
}
