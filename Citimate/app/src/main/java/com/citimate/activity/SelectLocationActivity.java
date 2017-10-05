package com.citimate.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.citimate.R;
import com.citimate.adapter.home.SelectLocationAdapter;
import com.citimate.bean.home.SelectLocationModel;

import java.util.ArrayList;

public class SelectLocationActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_back_button;
    private RecyclerView rvSelectLocation;
    private ArrayList<SelectLocationModel> selectLocationModels;
    private SelectLocationAdapter selectLocationAdapter;
    private LinearLayoutManager mLayoutManager;
    private String[] name = {"New York", "Miami", "Los Angels", "California", "San Francisco"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_location);
        initialization();
    }

    public void initialization() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.color_yellow));
        }


        iv_back_button = (ImageView) findViewById(R.id.iv_back_button);
        iv_back_button.setOnClickListener(this);

//        RecyclerView Id
        rvSelectLocation = (RecyclerView) findViewById(R.id.rvSelectLocation);
        rvSelectLocation.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        rvSelectLocation.setLayoutManager(mLayoutManager);
        selectLocationModels = new ArrayList<>();
        setValues();
    }

    //    Static Data Set Method
    private void setValues() {
        for (int i = 0; i < name.length; i++) {
            SelectLocationModel listModel = new SelectLocationModel();
            listModel.setLocation(name[i]);
            selectLocationModels.add(listModel);
        }
        selectLocationAdapter = new SelectLocationAdapter(SelectLocationActivity.this, selectLocationModels);
        rvSelectLocation.setAdapter(selectLocationAdapter);
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
