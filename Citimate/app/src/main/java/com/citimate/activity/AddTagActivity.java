package com.citimate.activity;

import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.citimate.R;
import com.citimate.adapter.saved.SavedAddTagListAdapter;
import com.citimate.bean.saved.SavedAddTagListModel;

import java.util.ArrayList;

public class AddTagActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_back_button;
    private TextView tvDone;
    private RecyclerView rvTagList;
    private RelativeLayout addTagLayout;
    private ArrayList<SavedAddTagListModel> savedAddTagListModels;
    private SavedAddTagListAdapter savedAddTagListAdapter;

    private String[] name = {"English Pub", "DJ Bar", "Night Bar", "Unlimited Brink", "Party", "Adult Bar-18+", "Night Club",
            "Lounge", "Sport Bar", "Restaurant"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tag);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.color_yellow));
        }

        initialization();
    }

    //    Views Id Initialize Method
    public void initialization() {
//        ImageView Id
        iv_back_button = (ImageView) findViewById(R.id.iv_back_button);

//        TextView Id
        tvDone = (TextView) findViewById(R.id.tvDone);

//        RelativeLayout Id
        addTagLayout = (RelativeLayout) findViewById(R.id.addTagLayout);

//        RecyclerView Setup
        rvTagList = (RecyclerView) findViewById(R.id.rvTagList);
        rvTagList.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 1);
        rvTagList.setLayoutManager(layoutManager);
        savedAddTagListModels = new ArrayList<>();
        setValues();

//        Click Listener
        iv_back_button.setOnClickListener(this);
        addTagLayout.setOnClickListener(this);
        tvDone.setOnClickListener(this);
    }

    //    Static Data ArrayList Add Method
    private void setValues() {
        for (int i = 0; i < name.length; i++) {
            SavedAddTagListModel listModel = new SavedAddTagListModel();
            listModel.setTagListName(name[i]);
            savedAddTagListModels.add(listModel);
        }
        savedAddTagListAdapter = new SavedAddTagListAdapter(AddTagActivity.this, savedAddTagListModels);
        rvTagList.setAdapter(savedAddTagListAdapter);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.addTagLayout:
                showDialog();
                break;
            case R.id.iv_back_button:
                finish();
                break;
            case R.id.tvDone:
                finish();
                break;
        }
    }

    //    Add Tag  Alert Dialog Method
    private void showDialog() {
        final Dialog dialog = new Dialog(AddTagActivity.this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.add_tag_dialog);

        ImageButton iv_back_button = (ImageButton) dialog.findViewById(R.id.iv_back_button);

        iv_back_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
            }
        });

        TextView tvAdd = (TextView) dialog.findViewById(R.id.tvAdd);

        tvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
