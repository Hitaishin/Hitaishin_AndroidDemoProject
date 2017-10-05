package com.citimate.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.citimate.R;
import com.citimate.adapter.saved.TagViewDetailsAdapter;
import com.citimate.bean.saved.TagViewDetailsModel;

import java.util.ArrayList;

public class TagViewDetailsActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rvTagViewDetails;
    private ArrayList<TagViewDetailsModel> savedListModels;
    private TagViewDetailsAdapter savedListAdapter;
    private RelativeLayout addPlaceLayout;
    private ImageView iv_back_button;
    private LinearLayoutManager mLayoutManager;
    private TextView tv_title_toolbar;

    private String[] name = {"Banglore Pub", "Sayaji", "Guru Kripa", "Mantis Restaurants", "Bear Bar", "Beer Gardom"};
    private String[] tags = {"Pub / Restaurants", "Sayaji / Restaurants", "Guru Kripa / Restaurants", "Mantis Restaurants", "Bar / Pubs", "Beer Gardom / Restaurants"};
    private String[] distance = {"1.2 Miles", "1.6 Miles", "1.7 Miles", "2.2 Miles", "3.2 Miles", "5.2 Miles"};
    private String[] rating = {"2", "3", "1", "4", "3", "1"};
    private int[] image = {R.drawable.ab, R.drawable.bc, R.drawable.cd, R.drawable.de,
            R.drawable.ef, R.drawable.fg};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag_view_details);
        initialization();
    }

    //    Views Id Initialize Method
    public void initialization() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.color_yellow));
        }

//        RelativeLayout Id
        addPlaceLayout = (RelativeLayout) findViewById(R.id.addPlaceLayout);

//      ImageView Id
        iv_back_button = (ImageView) findViewById(R.id.iv_back_button);

//        TextView Id
        tv_title_toolbar = (TextView) findViewById(R.id.tv_title_toolbar);
        tv_title_toolbar.setText(getIntent().getStringExtra("name"));

//        Click Listener
        addPlaceLayout.setOnClickListener(this);
        iv_back_button.setOnClickListener(this);

//        RecyclerView Setup
        rvTagViewDetails = (RecyclerView) findViewById(R.id.rvTagViewDetails);
        rvTagViewDetails.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(TagViewDetailsActivity.this);
        rvTagViewDetails.setLayoutManager(mLayoutManager);
        savedListModels = new ArrayList<>();
        setValues();
    }

    //    Static Data Set Method
    private void setValues() {
        for (int i = 0; i < name.length; i++) {
            TagViewDetailsModel listModel = new TagViewDetailsModel();
            listModel.setItemImage(image[i]);
            listModel.setItemName(name[i]);
            listModel.setDistance(distance[i]);
            listModel.setTags(tags[i]);
            listModel.setRating(rating[i]);
            savedListModels.add(listModel);
        }
        savedListAdapter = new TagViewDetailsAdapter(TagViewDetailsActivity.this, savedListModels);
        rvTagViewDetails.setAdapter(savedListAdapter);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.addPlaceLayout:
                Intent intent = new Intent(TagViewDetailsActivity.this, AddPlaceActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                break;

            case R.id.iv_back_button:
                finish();
                break;
        }
    }
}
