package com.citimate.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.citimate.R;
import com.citimate.adapter.home.ReviewListAdapter;
import com.citimate.bean.home.ReviewListModel;

import java.util.ArrayList;

public class ReviewActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_back_button;
    private RecyclerView rvReview;
    private ArrayList<ReviewListModel> reviewListModels;
    private ReviewListAdapter reviewListAdapter;
    private String[] Description;
    private String[] time = {"30 min Ago", "2 days Ago", "14 Feb,2017", "30 Jan,2017", "25 Jan,2017", "20 Jan,2017"};
    private String[] rating = {"2", "3", "1", "4", "3", "1"};
    private String[] userName = {"Robot", "Wacca Cool", "Mannue Jack", "Devid Thomes ", "Mackle More", "Usher's Mack"};
    private int[] userProfile = {R.drawable.balak, R.drawable.ic_image_usera, R.drawable.ic_image_userb, R.drawable.ic_image_userc,
            R.drawable.ic_image_userd, R.drawable.ic_image_usere};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        initialization();
    }

    public void initialization() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.color_yellow));
        }

        Description = getResources().getStringArray(R.array.my_array);

//        ImageView Id
        iv_back_button = (ImageView) findViewById(R.id.iv_back_button);

        iv_back_button.setOnClickListener(this);

//        RecyclerView Id
        rvReview = (RecyclerView) findViewById(R.id.rvReview);
        rvReview.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 1);
        rvReview.setLayoutManager(layoutManager);
        reviewListModels = new ArrayList<>();
        setValues();
    }

    //    Static Data Set Method
    private void setValues() {
        for (int i = 0; i < userName.length; i++) {
            ReviewListModel listModel = new ReviewListModel();
            listModel.setUserProfile(userProfile[i]);
            listModel.setUserName(userName[i]);
            listModel.setDescription(Description[i]);
            listModel.setTime(time[i]);
            listModel.setRating(rating[i]);
            reviewListModels.add(listModel);
        }
        reviewListAdapter = new ReviewListAdapter(ReviewActivity.this, reviewListModels);
        rvReview.setAdapter(reviewListAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back_button:
                finish();
                break;
        }
    }
}
