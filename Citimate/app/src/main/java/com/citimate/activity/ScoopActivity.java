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
import com.citimate.adapter.home.ScoopListAdapter;
import com.citimate.bean.home.ScoopListModel;

import java.util.ArrayList;

public class ScoopActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView iv_back_button;
    RecyclerView rvScoop;
    private ArrayList<ScoopListModel> scoopListModels;
    private ScoopListAdapter scoopListAdapter;

    String[] comment = {"Start following you", "Has update DJ club", "Has comment on your post", "Start following you", "Has update DJ club", "Has comment on your post"};
    String[] time = {"21 min Ago", "30 min Ago", "38 min Ago", "40 min Ago", "50 min Ago", "57 min Ago"};
    String[] userName = {"Robot", "Wacca Cool", "Mannue Jack", "Devid Thomes ", "Mackle More", "Usher's Mack"};
    int[] userProfile = {R.drawable.balak, R.drawable.ic_image_usera, R.drawable.ic_image_userb, R.drawable.ic_image_userc,
            R.drawable.ic_image_userd, R.drawable.ic_image_usere};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoop);
        initialization();
    }

    //    Views Id Initialize Method
    public void initialization() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.color_yellow));
        }

//        ImageView Id
        iv_back_button = (ImageView) findViewById(R.id.iv_back_button);
        iv_back_button.setOnClickListener(this);

//        RecyclerView Id
        rvScoop = (RecyclerView) findViewById(R.id.rvScoop);
        rvScoop.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvScoop.setLayoutManager(layoutManager);
        scoopListModels = new ArrayList<>();
        setValues();
    }

    //    Static Data Set Method
    private void setValues() {
        for (int i = 0; i < userName.length; i++) {
            ScoopListModel listModel = new ScoopListModel();
            listModel.setUserProfile(userProfile[i]);
            listModel.setUserName(userName[i]);
            listModel.setComment(comment[i]);
            listModel.setTime(time[i]);
            scoopListModels.add(listModel);
        }
        scoopListAdapter = new ScoopListAdapter(ScoopActivity.this, scoopListModels);
        rvScoop.setAdapter(scoopListAdapter);
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
