package com.citimate.activity;

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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.citimate.R;
import com.citimate.fragment.following.userprofile.FollowersFragment;
import com.citimate.fragment.following.userprofile.FollowingFragment;
import com.citimate.fragment.following.userprofile.TagListFragment;

import java.util.ArrayList;
import java.util.List;

public class FollowingUserProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView ivProfile, iv_back_button;
    private TextView tvFollow, tvUserName, tvFollowing, tvFollower, tvUserDetails;
    private RelativeLayout layoutMid;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_following_user_profile);
        initialization();
    }

    //    Views Id Initialize Method
    public void initialization() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.color_yellow));
        }

//        ViewPager Setup
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

//        ImageView Id
        ivProfile = (ImageView) findViewById(R.id.ivProfile);
        iv_back_button = (ImageView) findViewById(R.id.iv_back_button);

//        TextView Id
        tvUserName = (TextView) findViewById(R.id.tvUserName);
        tvFollow = (TextView) findViewById(R.id.tvFollow);
        tvFollowing = (TextView) findViewById(R.id.tvFollowing);
        tvFollower = (TextView) findViewById(R.id.tvFollower);
        tvUserDetails = (TextView) findViewById(R.id.tvUserDetails);

//        RelativeLayout Id
        layoutMid = (RelativeLayout) findViewById(R.id.layoutMid);

//        Click Listener
        tvFollow.setOnClickListener(this);
        iv_back_button.setOnClickListener(this);
    }

    private void setupViewPager(final ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FollowingFragment(), "Following");
        adapter.addFragment(new FollowersFragment(), "Follower");
        adapter.addFragment(new TagListFragment(), "Tag List");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.iv_back_button:
                finish();
                break;

            case R.id.tvFollow:
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
}
