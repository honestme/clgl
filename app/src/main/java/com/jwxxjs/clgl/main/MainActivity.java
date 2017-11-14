package com.jwxxjs.clgl.main;


import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;


import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.jwxxjs.clgl.R;
import com.jwxxjs.clgl.car.CarFragment;
import com.jwxxjs.clgl.message.MessageFragment;
import com.jwxxjs.clgl.mvp.MVPBaseActivity;
import com.jwxxjs.clgl.user.UserFragment;
import com.lhh.apst.library.AdvancedPagerSlidingTabStrip;
import com.lhh.apst.library.CustomPagerSlidingTabStrip;
import com.lhh.apst.library.Margins;

import butterknife.BindDrawable;
import butterknife.BindString;
import butterknife.BindView;


/**
 * MVPPlugin
 *  邮箱 784787081@qq.com
 */

public class MainActivity extends MVPBaseActivity<MainContract.View, MainPresenter> implements MainContract.View,ViewPager.OnPageChangeListener {

    //UI控件
    @BindView(R.id.main_tab)
    AdvancedPagerSlidingTabStrip mTabLayout;

    @BindView(R.id.main_viewpager)
    ViewPager mViewPager;

    @BindString(R.string.tablayout_tab_vehicle)
    String mTabVehicleTitle;
    @BindString(R.string.tablayout_tab_message)
    String mTabMessageTitle;
    @BindString(R.string.tablayout_tab_user)
    String mTabUserTitle;

    @BindDrawable(R.mipmap.nav_car_nor)
    Drawable mTabIconCarUnselected;
    @BindDrawable(R.mipmap.nav_car_sel)
    Drawable mTabIconCarSelected;
    @BindDrawable(R.mipmap.nav_mes_nor)
    Drawable mTabIconMessageUnselected;
    @BindDrawable(R.mipmap.nav_mes_sel)
    Drawable mTabIconMessageSelected;
    @BindDrawable(R.mipmap.nav_user_nor)
    Drawable mTabIconUserSelected;
    @BindDrawable(R.mipmap.nav_user_sel)
    Drawable mTabIconUserUnselected;

    CarFragment mCarFragment;
    MessageFragment mMessageFragment;
    UserFragment mUserFragment;

    PagerAdapter mPagerAdapter;

    //私有成员变量

    private MainPresenter mMainPresenter;

    private static final int VIEW_SIZE = 3;
    private static final int VIEW_FIRST = 0;
    private static final int VIEW_SECOND = 1;
    private static final int VIEW_THIRD = 2;
    private static final int VIEW_FORTH = 3;

    private int mSize = 0;


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

    private void initFragments() {

        if (null == mCarFragment) {
            mCarFragment = new CarFragment();
        }
        if (null == mMessageFragment) {
            mMessageFragment = new MessageFragment();
        }
        if (null == mUserFragment) {
            mUserFragment = new UserFragment();
        }

        mSize = getResources().getDimensionPixelSize(R.dimen.main_tab_size);

        mPagerAdapter = new PagerAdapter(getSupportFragmentManager());
        mPagerAdapter.notifyDataSetChanged();

        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setCurrentItem(VIEW_FIRST);
        mTabLayout.setOnPageChangeListener(this);
        mTabLayout.setViewPager(mViewPager);

    }

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    public class PagerAdapter extends android.support.v4.app.FragmentStatePagerAdapter implements
            AdvancedPagerSlidingTabStrip.IconTabProvider,
            AdvancedPagerSlidingTabStrip.LayoutProvider,
            AdvancedPagerSlidingTabStrip.TipsProvider {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            if (position >= 0 && position < VIEW_SIZE) {
                switch (position) {
                    case 0:
                        return mCarFragment;
                    case 1:
                        return mMessageFragment;
                    case 2:
                        return mUserFragment;
                    default:
                        break;
                }
            }

            return null;
        }

        @Override
        public int getCount() {
            return VIEW_SIZE;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if (position >= 0 && position < VIEW_SIZE) {
                switch (position) {
                    case VIEW_FIRST:
                        return mTabVehicleTitle;
                    case VIEW_SECOND:
                        return mTabMessageTitle;
                    case VIEW_THIRD:
                        return mTabUserTitle;
                    default:
                        break;
                }
            }
            return null;
        }

        @Override
        public Drawable getPageIcon(int position) {
            if (position >= 0 && position < VIEW_SIZE) {
                switch (position) {
                    case VIEW_FIRST:
                        return mTabIconCarUnselected;
                    case VIEW_SECOND:
                        return mTabIconMessageUnselected;
                    case VIEW_THIRD:
                        return mTabIconUserUnselected;
                    default:
                        break;
                }
            }
            return null;
        }

        @Override
        public Drawable getPageSelectIcon(int position) {
            if (position >= 0 && position < VIEW_SIZE) {
                switch (position) {
                    case VIEW_FIRST:
                        return mTabIconCarSelected;
                    case VIEW_SECOND:
                        return mTabIconMessageSelected;
                    case VIEW_THIRD:
                        return mTabIconUserSelected;
                    default:
                        break;
                }
            }
            return null;
        }

        @Override
        public Rect getPageIconBounds(int position) {
            return new Rect(0, 0, mSize, mSize);
        }

        @Override
        public float getPageWeight(int position) {
            if (position >= 0 && position < VIEW_SIZE) {
                switch (position) {
                    case VIEW_FIRST:
                        return 0.92f;
                    case VIEW_SECOND:
                        return 1.0f;
                    case VIEW_THIRD:
                        return 1.0f;
                    default:
                        break;
                }
            }
            return 1.0f;
        }

        @Override
        public int[] getPageRule(int position) {
            if (position >= 0 && position < VIEW_SIZE) {
                switch (position) {
                    case VIEW_FIRST:
                        return new int[]{
                                RelativeLayout.ALIGN_PARENT_LEFT};
                    case VIEW_SECOND:
                        return new int[]{
                                RelativeLayout.ALIGN_PARENT_LEFT};
                    case VIEW_THIRD:
                        return new int[]{
                                RelativeLayout.ALIGN_PARENT_RIGHT};
                    default:
                        break;
                }
            }
            return new int[0];
        }

        @Override
        public Margins getPageMargins(int position) {
            if (position >= 0 && position < VIEW_SIZE) {
                switch (position) {
                    case VIEW_FIRST:
                        return new Margins(getResources().getDimensionPixelSize(R.dimen.home_bar_icon_margins), 0, 0, 0);
                    case VIEW_SECOND:
                        return null;
                    case VIEW_THIRD:
                        return null;
                    default:
                        break;
                }
            }
            return null;
        }

        @Override
        public int[] getTipsRule(int position) {
            if (position >= 0 && position < VIEW_SIZE) {
                switch (position) {
                    case VIEW_FIRST:
                        return new int[]{
                                RelativeLayout.ALIGN_PARENT_LEFT};
                    case VIEW_SECOND:
                        return new int[]{
                                RelativeLayout.ALIGN_PARENT_LEFT};
                    case VIEW_THIRD:
                        return new int[]{
                                RelativeLayout.ALIGN_PARENT_RIGHT};
                    default:
                        break;
                }

            }
            return new int[0];
        }

        @Override
        public Margins getTipsMargins(int position) {
            if (position >= 0 && position < VIEW_SIZE) {
                switch (position) {
                    case VIEW_FIRST:
                        return new Margins(4 * getResources().getDimensionPixelSize(R.dimen.psts_dot_m_right), 0, 0, 0);
                    default:
                        break;
                }
            }
            return null;
        }

        @Override
        public Drawable getTipsDrawable(int position) {
            return null;
        }
    }
}
