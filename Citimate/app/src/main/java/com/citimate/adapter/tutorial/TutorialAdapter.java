package com.citimate.adapter.tutorial;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class TutorialAdapter extends FragmentPagerAdapter {

    private TextView tvSkip;
    private ImageView ivNext;
    private List<Fragment> fragments;

    public TutorialAdapter(FragmentManager fm, List<Fragment> list, TextView tvSkip, ImageView ivNext) {
        super(fm);
        fragments = list;
        this.tvSkip = tvSkip;
        this.ivNext = ivNext;
    }

    @Override
    public Fragment getItem(int position) {

        if (position == 0) {
            tvSkip.setVisibility(View.GONE);
            ivNext.setVisibility(View.GONE);
        } else {
            tvSkip.setVisibility(View.VISIBLE);
            ivNext.setVisibility(View.VISIBLE);
        }
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}
