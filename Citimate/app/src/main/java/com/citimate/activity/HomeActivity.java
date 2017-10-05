package com.citimate.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.citimate.R;
import com.citimate.adapter.home.HomeCategoryListAdapter;
import com.citimate.bean.home.CategoryListModel;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView ivDropDown, iv_notifaiction;
    private TextView tvSelectLocation, tvFind;
    private RelativeLayout layoutMid;
    private RecyclerView rvBarList;
    private LinearLayout layout_home, layout_saved, layout_following, layout_profile, layout_more;
    private ArrayList<CategoryListModel> categoryListModels;
    private HomeCategoryListAdapter categoryListAdapter;

    private String[] name = {"Bar", "Lounge", "Restaurant", "Night Club", "Bar", "Lounge", "Restaurant", "Night Club",};
    private int[] image = {R.mipmap.box_white_bar, R.mipmap.box_white_beergardom, R.mipmap.box_white_rest, R.mipmap.box_white_pub,
            R.mipmap.box_white_bar, R.mipmap.box_white_beergardom, R.mipmap.box_white_rest, R.mipmap.box_white_pub};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initialization();
    }

    //    Views Id Initialize Method
    public void initialization() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.color_yellow));
        }

//        ImageView Id
        iv_notifaiction = (ImageView) findViewById(R.id.iv_notifaiction);
        ivDropDown = (ImageView) findViewById(R.id.ivDropDown);
        tvSelectLocation = (TextView) findViewById(R.id.tvSelectLocation);

//        TextView Id
        tvFind = (TextView) findViewById(R.id.tvFind);

//        LinearLayout Id
        layout_home = (LinearLayout) findViewById(R.id.layout_home);
        layout_saved = (LinearLayout) findViewById(R.id.layout_saved);
        layout_following = (LinearLayout) findViewById(R.id.layout_following);
        layout_profile = (LinearLayout) findViewById(R.id.layout_profile);
        layout_more = (LinearLayout) findViewById(R.id.layout_more);

//        RelativeLayout Id
        layoutMid = (RelativeLayout) findViewById(R.id.layoutMid);

//        RecyclerView Setup
        rvBarList = (RecyclerView) findViewById(R.id.rvBarList);
        rvBarList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 4);
        rvBarList.setLayoutManager(layoutManager);
        categoryListModels = new ArrayList<>();
        setValues();

        tvSelectLocation.setOnClickListener(this);
        tvFind.setOnClickListener(this);
        iv_notifaiction.setOnClickListener(this);
        layout_home.setOnClickListener(this);
        layout_saved.setOnClickListener(this);
        layout_following.setOnClickListener(this);
        layout_profile.setOnClickListener(this);
        layout_more.setOnClickListener(this);
        layoutMid.setOnClickListener(this);
    }

    //    Static Data Set Method
    private void setValues() {
        for (int i = 0; i < name.length; i++) {
            CategoryListModel listModel = new CategoryListModel();
            listModel.setBarName(name[i]);
            listModel.setBarImage(image[i]);
            categoryListModels.add(listModel);
        }
        categoryListAdapter = new HomeCategoryListAdapter(HomeActivity.this, categoryListModels);
        rvBarList.setAdapter(categoryListAdapter);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.layoutMid:
                Intent intent = new Intent(HomeActivity.this, SelectLocationActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                break;

            case R.id.tvSelectLocation:
                Intent location = new Intent(HomeActivity.this, SelectLocationActivity.class);
                startActivity(location);
                overridePendingTransition(0, 0);
                break;

            case R.id.tvFind:
                break;

            case R.id.layout_saved:
                Intent intent4 = new Intent(HomeActivity.this, SavedActivity.class);
                startActivity(intent4);
                overridePendingTransition(0, 0);
                finish();
                break;

            case R.id.layout_following:
                Intent followingIntent = new Intent(HomeActivity.this, FollowingActivity.class);
                startActivity(followingIntent);
                overridePendingTransition(0, 0);
                finish();
                break;

            case R.id.layout_profile:
                Intent intent5 = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(intent5);
                overridePendingTransition(0, 0);
                finish();
                break;

            case R.id.layout_more:
                Intent intent1 = new Intent(HomeActivity.this, MoreActivity.class);
                startActivity(intent1);
                overridePendingTransition(0, 0);
                finish();
                break;

            case R.id.iv_notifaiction:
                Intent intent2 = new Intent(HomeActivity.this, ScoopActivity.class);
                startActivity(intent2);
                overridePendingTransition(0, 0);
                break;
        }
    }
}
