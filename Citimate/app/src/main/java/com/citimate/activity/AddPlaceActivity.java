package com.citimate.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.citimate.R;
import com.citimate.adapter.saved.AddPlaceListAdapter;
import com.citimate.bean.saved.AddPlaceListModel;

import java.util.ArrayList;
import java.util.Locale;

public class AddPlaceActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_back_button, ivRemoveSearch;
    private EditText etSearch;
    private RecyclerView rvAddPlace;
    private ArrayList<AddPlaceListModel> addPlaceListModels;
    private AddPlaceListAdapter addPlaceListAdapter;

    private String[] name = {"RainBow Bar & Grill", "The Federal Bar", "Guru Kripa", "Mantis Restaurants", "Jineya Ramen Bar", "RainBow Bar & Grill"};
    private String[] address = {"9015 Sunset Blvd,62,NCM Market Near of iBelcx Hotel,West Hollywood,CA 90069,USA",
            "9015 Sunset Blvd,62,NCM Market Near of iBelcx Hotel,West Hollywood,CA 90069,USA",
            "9015 Sunset Blvd,62,NCM Market Near of iBelcx Hotel,West Hollywood,CA 90069,USA",
            "9015 Sunset Blvd,62,NCM Market Near of iBelcx Hotel,West Hollywood,CA 90069,USA",
            "9015 Sunset Blvd,62,NCM Market Near of iBelcx Hotel,West Hollywood,CA 90069,USA",
            "9015 Sunset Blvd,62,NCM Market Near of iBelcx Hotel,West Hollywood,CA 90069,USA"};

    private int[] image = {R.drawable.ab, R.drawable.bc, R.drawable.cd, R.drawable.de,
            R.drawable.ef, R.drawable.fg};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_place);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.color_yellow));
        }

        initialization();
        filter();
    }

    //    Views Id Initialize Method
    public void initialization() {
//        ImageView Id
        iv_back_button = (ImageView) findViewById(R.id.iv_back_button);
        ivRemoveSearch = (ImageView) findViewById(R.id.ivRemoveSearch);

//        EditText Id
        etSearch = (EditText) findViewById(R.id.etSearch);

//        RecyclerView Setup
        rvAddPlace = (RecyclerView) findViewById(R.id.rvAddPlace);
        rvAddPlace.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 1);
        rvAddPlace.setLayoutManager(layoutManager);
        addPlaceListModels = new ArrayList<>();
        setValues();

//        Click Listener
        iv_back_button.setOnClickListener(this);
    }

    //    Search Filter Method
    private void filter() {
        etSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub

                try {
                    String text = etSearch.getText().toString().toLowerCase(Locale.getDefault());
                    int textlength = etSearch.getText().length();

                    addPlaceListAdapter.filter(text, textlength);
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

    //    Static Data ArrayList Add Method
    private void setValues() {
        for (int i = 0; i < name.length; i++) {
            AddPlaceListModel listModel = new AddPlaceListModel();
            listModel.setUserProfile(image[i]);
            listModel.setName(name[i]);
            listModel.setAddress(address[i]);
            addPlaceListModels.add(listModel);
        }
        addPlaceListAdapter = new AddPlaceListAdapter(AddPlaceActivity.this, addPlaceListModels);
        rvAddPlace.setAdapter(addPlaceListAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back_button:
                finish();
                break;

            case R.id.ivRemoveSearch:
                etSearch.setText("");
                break;
        }
    }
}
