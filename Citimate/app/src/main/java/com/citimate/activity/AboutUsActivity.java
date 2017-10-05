package com.citimate.activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.citimate.R;

public class AboutUsActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_back_button;
    private TextView tvVersion, tvAboutSite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.color_yellow));
        }

        idInit();
    }

    //    Views Id Initialize Method
    private void idInit() {
//        ImageView Id
        iv_back_button = (ImageView) findViewById(R.id.iv_back_button);

//        TextView Id
        tvVersion = (TextView) findViewById(R.id.tvVersion);
        tvAboutSite = (TextView) findViewById(R.id.tvAboutSite);

        tvAboutSite.setPaintFlags(tvAboutSite.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);


        PackageManager manager = this.getPackageManager();
        PackageInfo info = null;
        try {
            info = manager.getPackageInfo(
                    this.getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        String version = info.versionName;
        tvVersion.setText("Version " + version);

//        View Click Listener
        iv_back_button.setOnClickListener(this);
        tvVersion.setOnClickListener(this);
        tvAboutSite.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_back_button:
                finish();
                break;

            case R.id.tvVersion:
                break;

            case R.id.tvAboutSite:
                break;
        }
    }
}
