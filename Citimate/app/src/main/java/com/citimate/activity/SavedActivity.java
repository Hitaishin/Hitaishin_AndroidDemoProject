package com.citimate.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.citimate.R;
import com.citimate.adapter.saved.SavedTagListAdapter;
import com.citimate.bean.saved.SavedTagListModel;

import java.util.ArrayList;

public class SavedActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_notifaiction;
    private TextView tvSavedList, tvAddTag;
    private RecyclerView rvTagList;
    private LinearLayout layout_home, layout_following, layout_profile, layout_more;
    private RelativeLayout savedLayout, addTagLayout;
    private ArrayList<SavedTagListModel> savedTagListModels;
    private SavedTagListAdapter savedTagListAdapter;

    private String[] name = {"English Pub", "DJ Bar", "Night Bar", "Unlimited Brink", "Party", "Adult Bar-18+"};
    private String[] count = {"(3)", "(12)", "(9)", "(20)", "(31)", "(2)"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved);
        initialization();
    }

    //    Views Id Initialize Method
    public void initialization() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.color_yellow));
        }

//        ImageView Id
        iv_notifaiction = (ImageView) findViewById(R.id.iv_notifaiction);

//        TextView Id
        tvSavedList = (TextView) findViewById(R.id.tvSavedList);
        tvAddTag = (TextView) findViewById(R.id.tvAddTag);

//        LinearLayout Id
        layout_home = (LinearLayout) findViewById(R.id.layout_home);
        layout_following = (LinearLayout) findViewById(R.id.layout_following);
        layout_profile = (LinearLayout) findViewById(R.id.layout_profile);
        layout_more = (LinearLayout) findViewById(R.id.layout_more);

//        RelativeLayout Id
        savedLayout = (RelativeLayout) findViewById(R.id.savedLayout);
        addTagLayout = (RelativeLayout) findViewById(R.id.addTagLayout);

//        Click Listener
        savedLayout.setOnClickListener(this);
        addTagLayout.setOnClickListener(this);
        iv_notifaiction.setOnClickListener(this);
        layout_home.setOnClickListener(this);
        layout_following.setOnClickListener(this);
        layout_profile.setOnClickListener(this);
        layout_more.setOnClickListener(this);

//        RecyclerView Setup
        rvTagList = (RecyclerView) findViewById(R.id.rvTagList);
        rvTagList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 1);
        rvTagList.setLayoutManager(layoutManager);
        savedTagListModels = new ArrayList<>();
        setValues();
    }

    //    Static Data Set Method
    private void setValues() {
        for (int i = 0; i < name.length; i++) {
            SavedTagListModel listModel = new SavedTagListModel();
            listModel.setTagListName(name[i]);
            listModel.setCount(count[i]);
            savedTagListModels.add(listModel);
        }
        savedTagListAdapter = new SavedTagListAdapter(SavedActivity.this, savedTagListModels);
        rvTagList.setAdapter(savedTagListAdapter);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.savedLayout:
                Intent intent = new Intent(SavedActivity.this, SavedListActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                break;

            case R.id.addTagLayout:
                Intent intent1 = new Intent(SavedActivity.this, AddTagActivity.class);
                startActivity(intent1);
                overridePendingTransition(0, 0);
                break;

            case R.id.layout_home:
                Intent intent2 = new Intent(SavedActivity.this, HomeActivity.class);
                startActivity(intent2);
                overridePendingTransition(0, 0);
                finish();
                break;

            case R.id.layout_following:
                Intent followingIntent = new Intent(SavedActivity.this, FollowingActivity.class);
                startActivity(followingIntent);
                overridePendingTransition(0, 0);
                finish();
                break;

            case R.id.layout_profile:
                Intent intent4 = new Intent(SavedActivity.this, ProfileActivity.class);
                startActivity(intent4);
                overridePendingTransition(0, 0);
                finish();
                break;

            case R.id.layout_more:
                Intent intent5 = new Intent(SavedActivity.this, MoreActivity.class);
                startActivity(intent5);
                overridePendingTransition(0, 0);
                finish();
                break;

            case R.id.iv_notifaiction:
                Intent intent6 = new Intent(SavedActivity.this, ScoopActivity.class);
                startActivity(intent6);
                overridePendingTransition(0, 0);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(SavedActivity.this, HomeActivity.class);
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
