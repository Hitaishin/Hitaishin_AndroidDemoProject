package com.citimate.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.citimate.R;
import com.citimate.adapter.tutorial.TutorialAdapter;
import com.citimate.fragment.tutorial.Tutorial1Fragment;
import com.citimate.fragment.tutorial.Tutorial2Fragment;
import com.citimate.fragment.tutorial.Tutorial3Fragment;
import com.citimate.fragment.tutorial.Tutorial4Fragment;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.List;

public class TutorialActivty extends AppCompatActivity implements View.OnClickListener {

    private ViewPager viewpager;
    private CirclePageIndicator circle_indicator;
    private TextView tvSkip;
    private ImageView ivNext;
    private PageListener pageListener;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_tutorial);
        idInit();
        setAdapter();
    }

    //    Views Id Initialize Method
    private void idInit() {
//        ViewPager Id
        viewpager = (ViewPager) findViewById(R.id.viewpager);

//        CirclePageIndicator Id
        circle_indicator = (CirclePageIndicator) findViewById(R.id.circle_indicator);

//        TextView Id
        tvSkip = (TextView) findViewById(R.id.tvSkip);

//        ImageView Id
        ivNext = (ImageView) findViewById(R.id.ivNext);

//        Click Listener
        tvSkip.setOnClickListener(this);
        ivNext.setOnClickListener(this);
    }

    //    ViewPager Adapter Set Method
    private void setAdapter() {
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new Tutorial1Fragment());
        fragments.add(new Tutorial2Fragment());
        fragments.add(new Tutorial3Fragment());
        fragments.add(new Tutorial4Fragment());
        TutorialAdapter pagerAdapter = new TutorialAdapter(getSupportFragmentManager(), fragments, tvSkip, ivNext);
        viewpager.setAdapter(pagerAdapter);
        circle_indicator.setViewPager(viewpager);
        final float density = getResources().getDisplayMetrics().density;
        circle_indicator.setRadius(4 * density);

        pageListener = new PageListener();
        viewpager.setOnPageChangeListener(pageListener);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvSkip:
                Intent intent = new Intent(TutorialActivty.this, LoginActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
                break;

            case R.id.ivNext:
                viewpager.arrowScroll(View.FOCUS_RIGHT);
                break;
        }
    }

    private class PageListener extends ViewPager.SimpleOnPageChangeListener {
        public void onPageSelected(int position) {
            circle_indicator.setCurrentItem(position);
            switch (position) {
                case 0:
                    tvSkip.setVisibility(View.VISIBLE);
                    ivNext.setVisibility(View.VISIBLE);
                    break;
                case 1:
                    tvSkip.setVisibility(View.VISIBLE);
                    ivNext.setVisibility(View.VISIBLE);
                    break;
                case 2:
                    tvSkip.setVisibility(View.VISIBLE);
                    ivNext.setVisibility(View.VISIBLE);
                    break;
                case 3:
                    tvSkip.setVisibility(View.GONE);
                    ivNext.setVisibility(View.GONE);
                    break;

            }
        }
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        System.exit(0);
        super.onBackPressed();
    }
}
