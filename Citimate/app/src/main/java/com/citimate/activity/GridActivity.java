package com.citimate.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.citimate.R;
import com.citimate.adapter.home.ListAdapter;
import com.citimate.bean.home.ListModel;

import java.util.ArrayList;
import java.util.Locale;

public class GridActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_back_button, iv_notifaiction, ivRemoveSearch;
    private TextView tvGridView, tvFind;
    private RelativeLayout layoutMid;
    private EditText etSearch;
    private RecyclerView rvGrid;
    private ArrayList<ListModel> listModels;
    private ListAdapter listAdapter;
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
        setContentView(R.layout.activity_grid);
        initialization();
        filter();
    }

    //    Views Id Initialize Method
    public void initialization() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.color_yellow));
        }

//        ImageView Id
        ivRemoveSearch = (ImageView) findViewById(R.id.ivRemoveSearch);
        iv_notifaiction = (ImageView) findViewById(R.id.iv_notifaiction);
        iv_back_button = (ImageView) findViewById(R.id.iv_back_button);

//        TextView Id
        tvGridView = (TextView) findViewById(R.id.tvGridView);
        tvFind = (TextView) findViewById(R.id.tvFind);

//        EditText Id
        etSearch = (EditText) findViewById(R.id.etSearch);

//        RelativeLayout Id
        layoutMid = (RelativeLayout) findViewById(R.id.layoutMid);

//        RecyclerView Setup
        rvGrid = (RecyclerView) findViewById(R.id.rvGrid);
        rvGrid.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        rvGrid.setLayoutManager(mLayoutManager);
        listModels = new ArrayList<ListModel>();
        setValues();

//        Click Listener
        tvGridView.setOnClickListener(this);
        iv_back_button.setOnClickListener(this);

        ivRemoveSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etSearch.setText("");
            }
        });
    }

    //    Filter Method
    private void filter() {
        etSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub

                try {
                    String text = etSearch.getText().toString().toLowerCase(Locale.getDefault());
                    int textlength = etSearch.getText().length();

                    listAdapter.filter(text, textlength);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
            }
        });
    }

    //    Static data set Method
    private void setValues() {
        for (int i = 0; i < name.length; i++) {
            ListModel listModel = new ListModel();
            listModel.setItemImage(image[i]);
            listModel.setItemName(name[i]);
            listModel.setDistance(distance[i]);
            listModel.setTags(tags[i]);
            listModel.setRating(rating[i]);
            listModels.add(listModel);
        }
        listAdapter = new ListAdapter(GridActivity.this, listModels);
        rvGrid.setAdapter(listAdapter);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.iv_back_button:
                finish();
                break;

            case R.id.tvGridView:
                Intent intent = new Intent(GridActivity.this, ListActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
                break;

        }
    }
}
