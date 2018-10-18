package com.mariocamarillo.unammascotas.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by erick.chaparro on 16,octubre,2018
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    private List<Fragment> fragments;

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragments){
        super(fm);
        this.fragments = fragments;
    }

    @Override
    public Fragment getItem(int i) {
        return fragments.get(i);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
