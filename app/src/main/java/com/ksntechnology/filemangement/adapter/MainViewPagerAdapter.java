package com.ksntechnology.filemangement.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ksntechnology.filemangement.fragment.Fragment1;
import com.ksntechnology.filemangement.fragment.Fragment2;
import com.ksntechnology.filemangement.fragment.Fragment3;

public class MainViewPagerAdapter extends FragmentStatePagerAdapter {

    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String[] tabName = {"Tab1", "Tab2", "Tab3"};
        return tabName[position];
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return Fragment1.newInstance();
            case 1:
                return Fragment2.newInstance();
            case 2:
                return Fragment3.newInstance();
                default:
                    return null;
        }
    }

    @Override
    public int getCount() {
        return 3;
    }

}
