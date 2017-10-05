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
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.citimate.R;
import com.citimate.fragment.profile.FollowersFragment;
import com.citimate.fragment.profile.FollowingFragment;
import com.citimate.fragment.profile.SavedListFragment;
import com.citimate.fragment.profile.TagListFragment;

import java.util.ArrayList;
import java.util.List;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView ivProfile;
    private TextView tvEditProfile, tvUserName, tvFollowing, tvFollower, tvUserDetails;
    private RelativeLayout layoutMid;
    private LinearLayout layout_home, layout_saved, layout_following, layout_profile, layout_more;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
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

//        TextView Id
        tvUserName = (TextView) findViewById(R.id.tvUserName);
        tvEditProfile = (TextView) findViewById(R.id.tvEditProfile);
        tvFollowing = (TextView) findViewById(R.id.tvFollowing);
        tvFollower = (TextView) findViewById(R.id.tvFollower);
        tvUserDetails = (TextView) findViewById(R.id.tvUserDetails);

//        LinearLayout Id
        layout_home = (LinearLayout) findViewById(R.id.layout_home);
        layout_saved = (LinearLayout) findViewById(R.id.layout_saved);
        layout_following = (LinearLayout) findViewById(R.id.layout_following);
        layout_profile = (LinearLayout) findViewById(R.id.layout_profile);
        layout_more = (LinearLayout) findViewById(R.id.layout_more);

//        RelativeLayout Id
        layoutMid = (RelativeLayout) findViewById(R.id.layoutMid);

//        Click Listener
        tvEditProfile.setOnClickListener(this);
        layout_home.setOnClickListener(this);
        layout_saved.setOnClickListener(this);
        layout_following.setOnClickListener(this);
        layout_more.setOnClickListener(this);
    }

    private void setupViewPager(final ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new FollowingFragment(), "Following");
        adapter.addFragment(new FollowersFragment(), "Follower");
        adapter.addFragment(new TagListFragment(), "Tag List");
        adapter.addFragment(new SavedListFragment(), "Saved List");
        viewPager.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.layout_saved:
                Intent intent2 = new Intent(ProfileActivity.this, SavedActivity.class);
                startActivity(intent2);
                overridePendingTransition(0, 0);
                finish();
                break;

            case R.id.layout_following:
                Intent followingIntent = new Intent(ProfileActivity.this, FollowingActivity.class);
                startActivity(followingIntent);
                overridePendingTransition(0, 0);
                finish();
                break;

            case R.id.layout_home:
                Intent intent5 = new Intent(ProfileActivity.this, HomeActivity.class);
                startActivity(intent5);
                overridePendingTransition(0, 0);
                finish();
                break;

            case R.id.layout_more:
                Intent intent1 = new Intent(ProfileActivity.this, MoreActivity.class);
                startActivity(intent1);
                overridePendingTransition(0, 0);
                finish();
                break;

            case R.id.tvEditProfile:
                Intent intent3 = new Intent(ProfileActivity.this, EditProfileActivity.class);
                startActivity(intent3);
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
        Intent intent = new Intent(ProfileActivity.this, HomeActivity.class);
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
