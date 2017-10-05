package com.citimate.activity;

import android.annotation.TargetApi;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.citimate.R;
import com.citimate.adapter.more.FAQListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FAQActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_back_button;
    private ExpandableListView elvFaqList;
    private FAQListAdapter faqListAdapter;

    private String[] question1 = {"What is Lorem Ipsum?", "Where does it come from?", "Why do we use it?", "Where can I get some?"};
    private String[] answer1 = {"Lorem Ipsum is simply dummy text of the printing and typesetting industry."
            , "Contrary to popular belief, Lorem Ipsum is not simply random text. "
            , "It is a long established fact that a reader will be distracted by the readable content of a page when looking at its layout."
            , "There are many variations of passages of Lorem Ipsum"};

    private HashMap<String, String> question_answer = new HashMap<String, String>();
    private String question = "", answer = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        initialization();
    }

    //    Views Id Initialize Method
    public void initialization() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.color_statusBar));
        }

//        ImageView Id
        iv_back_button = (ImageView) findViewById(R.id.iv_back_button);

//        ExpandableListView Id
        elvFaqList = (ExpandableListView) findViewById(R.id.elvFaqList);

//        Click Listener
        iv_back_button.setOnClickListener(this);

        for (int i = 0; i < question1.length; i++) {

            question = question1[i];
            answer = answer1[i];
            question_answer.put(question, answer);
        }

        List<String> list;
        list = new ArrayList<String>(question_answer.keySet());
        faqListAdapter = new FAQListAdapter(this, list, question_answer);
        elvFaqList.setAdapter(faqListAdapter);
        elvFaqList.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {

            }
        });
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN_MR2)
    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        Drawable drawable_groupIndicator = ContextCompat.getDrawable(this, R.drawable.expandable_list_indicator);
        int drawable_width = drawable_groupIndicator.getMinimumWidth();

        if (android.os.Build.VERSION.SDK_INT <
                android.os.Build.VERSION_CODES.JELLY_BEAN_MR2) {
            elvFaqList.setIndicatorBounds(
                    elvFaqList.getWidth() - drawable_width,
                    elvFaqList.getWidth());
        } else {
            elvFaqList.setIndicatorBoundsRelative(
                    elvFaqList.getWidth() - drawable_width,
                    elvFaqList.getWidth());
        }
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
