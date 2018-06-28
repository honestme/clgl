package com.jwxxjs.clgl.main.homepage;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.jwxxjs.clgl.R;
import com.jwxxjs.clgl.main.homepage.fragments.category.CategoryFragment;
import com.jwxxjs.clgl.main.homepage.fragments.map.MapFragment;
import com.jwxxjs.clgl.main.homepage.fragments.personal.PersonalFragment;
import com.jwxxjs.clgl.main.homepage.fragments.report.ReportFragment;


/**
 * Created by zcl on 2018/1/24.
 *
 * @link
 * @description
 */

public class HomePagerAdapter extends FragmentPagerAdapter {

    private final String[] TITLES;
    private Fragment[] fragments;

    public HomePagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        TITLES = context.getResources().getStringArray(R.array.sections);
        fragments = new Fragment[TITLES.length];
    }


    @Override
    public Fragment getItem(int position) {
        if (fragments[position] == null) {
            switch (position) {
                case 0:
                    fragments[position] = new ReportFragment();
                    break;
                case 1:
                    fragments[position] = new CategoryFragment();
                    break;
                case 2:
                    fragments[position] = new PersonalFragment();
                    break;
                case 3:
                    fragments[position] = new MapFragment();
                    break;
                default:
                    break;
            }
        }
        return fragments[position];
    }


    @Override
    public int getCount() {
        return TITLES.length;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }


}
