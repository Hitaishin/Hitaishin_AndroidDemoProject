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

import com.citimate.R;
import com.citimate.adapter.saved.SaveSavedListAdapter;
import com.citimate.bean.saved.SaveSavedListModel;

import java.util.ArrayList;

public class SavedListActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rvSavedList;
    private ArrayList<SaveSavedListModel> savedListModels;
    private SaveSavedListAdapter savedListAdapter;
    private RelativeLayout addPlaceLayout;
    private ImageView iv_back_button;
    private LinearLayoutManager mLayoutManager;

    private String[] name = {"Banglore Pub", "Sayaji", "Guru Kripa", "Mantis Restaurants", "Bear Bar", "Beer Gardom"};
    private String[] tags = {"Pub / Restaurants", "Sayaji / Restaurants", "Guru Kripa / Restaurants", "Mantis Restaurants", "Bar / Pubs", "Beer Gardom / Restaurants"};
    private String[] distance = {"1.2 Miles", "1.6 Miles", "1.7 Miles", "2.2 Miles", "3.2 Miles", "5.2 Miles"};
    private String[] rating = {"2", "3", "1", "4", "3", "1"};
    private int[] image = {R.drawable.ab, R.drawable.bc, R.drawable.cd, R.drawable.de,
            R.drawable.ef, R.drawable.fg};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_list);
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

//        ImageView Id
        iv_back_button = (ImageView) findViewById(R.id.iv_back_button);

        addPlaceLayout.setOnClickListener(this);
        iv_back_button.setOnClickListener(this);

//        RecyclerView Setup
        rvSavedList = (RecyclerView) findViewById(R.id.rvSavedList);
        rvSavedList.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(SavedListActivity.this);
        rvSavedList.setLayoutManager(mLayoutManager);
        savedListModels = new ArrayList<>();
        setValues();
    }

    //    Static Data Set Method
    private void setValues() {
        for (int i = 0; i < name.length; i++) {
            SaveSavedListModel listModel = new SaveSavedListModel();
            listModel.setItemImage(image[i]);
            listModel.setItemName(name[i]);
            listModel.setDistance(distance[i]);
            listModel.setTags(tags[i]);
            listModel.setRating(rating[i]);
            savedListModels.add(listModel);
        }
        savedListAdapter = new SaveSavedListAdapter(SavedListActivity.this, savedListModels);
        rvSavedList.setAdapter(savedListAdapter);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.addPlaceLayout:
                Intent intent = new Intent(SavedListActivity.this, AddPlaceActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                break;

            case R.id.iv_back_button:
                finish();
                break;
        }
    }
}
