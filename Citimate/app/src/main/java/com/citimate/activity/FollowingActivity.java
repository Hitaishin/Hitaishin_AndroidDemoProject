package com.citimate.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.citimate.R;
import com.citimate.fragment.following.FollowerFragment;
import com.citimate.fragment.following.FollowingFragment;
import com.citimate.fragment.following.userprofile.FollowingTagListFragment;

import java.util.ArrayList;
import java.util.List;

public class FollowingActivity extends AppCompatActivity implements View.OnClickListener {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private LinearLayout layout_home, layout_saved, layout_following, layout_profile, layout_more;
    private ImageView iv_notifaiction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_following);
        initialization();
    }

    //    Views Id Initialize Method
    public void initialization() {
        //    ViewPager Setup
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        //Bottom bar Layout
        iv_notifaiction = (ImageView) findViewById(R.id.iv_notifaiction);
        layout_home = (LinearLayout) findViewById(R.id.layout_home);
        layout_saved = (LinearLayout) findViewById(R.id.layout_saved);
        layout_following = (LinearLayout) findViewById(R.id.layout_following);
        layout_profile = (LinearLayout) findViewById(R.id.layout_profile);
        layout_more = (LinearLayout) findViewById(R.id.layout_more);

        iv_notifaiction.setOnClickListener(this);
        layout_home.setOnClickListener(this);
        layout_saved.setOnClickListener(this);
        layout_following.setOnClickListener(this);
        // layout_activity.setOnClickListener(this);
        layout_profile.setOnClickListener(this);
        layout_more.setOnClickListener(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.color_statusBar));
        }

    }

    //    ViewPager Setup
    private void setupViewPager(final ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FollowingFragment(), "Following");
        adapter.addFragment(new FollowerFragment(), "Follower");
        adapter.addFragment(new FollowingTagListFragment(), "Tag List");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.layout_home:
                Intent homeIntent = new Intent(FollowingActivity.this, HomeActivity.class);
                startActivity(homeIntent);
                overridePendingTransition(0, 0);
                finish();
                break;

            case R.id.layout_saved:
                Intent intent4 = new Intent(FollowingActivity.this, SavedActivity.class);
                startActivity(intent4);
                overridePendingTransition(0, 0);
                finish();
                break;

            case R.id.layout_following:
                break;

            case R.id.layout_profile:
                Intent intent5 = new Intent(FollowingActivity.this, ProfileActivity.class);
                startActivity(intent5);
                overridePendingTransition(0, 0);
                finish();
                break;

            case R.id.layout_more:
                Intent intent1 = new Intent(FollowingActivity.this, MoreActivity.class);
                startActivity(intent1);
                overridePendingTransition(0, 0);
                finish();
                break;

            case R.id.iv_notifaiction:
                Intent intent2 = new Intent(FollowingActivity.this, ScoopActivity.class);
                startActivity(intent2);
                overridePendingTransition(0, 0);
                break;
        }
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(FollowingActivity.this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // To clean up all activities
        startActivity(intent);
        overridePendingTransition(0, 0);

        try {
            View view = this.getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finish();
    }
}
