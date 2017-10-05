package com.citimate.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.citimate.R;

public class MoreActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvChangePassword, tvAboutUs, tvFaq, tvPrivacyPolicy, tvTAndC, tvContactUs, tvRateUs, tvLogout;
    private LinearLayout layout_home, layout_saved, layout_following, layout_profile, layout_more;
    private ImageView iv_notifaiction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more);
        initialization();
    }

    //    Views Id Initialize Method
    public void initialization() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.color_yellow));
        }

//        ImageView Id
        iv_notifaiction = (ImageView) findViewById(R.id.iv_notifaiction);

//        TextView Id
        tvChangePassword = (TextView) findViewById(R.id.tvChangePassword);
        tvAboutUs = (TextView) findViewById(R.id.tvAboutUs);
        tvFaq = (TextView) findViewById(R.id.tvFaq);
        tvPrivacyPolicy = (TextView) findViewById(R.id.tvPrivacyPolicy);
        tvTAndC = (TextView) findViewById(R.id.tvTAndC);
        tvContactUs = (TextView) findViewById(R.id.tvContactUs);
        tvRateUs = (TextView) findViewById(R.id.tvRateUs);
        tvLogout = (TextView) findViewById(R.id.tvLogout);

//        LinearLayout Id
        layout_home = (LinearLayout) findViewById(R.id.layout_home);
        layout_saved = (LinearLayout) findViewById(R.id.layout_saved);
        layout_following = (LinearLayout) findViewById(R.id.layout_following);
        layout_profile = (LinearLayout) findViewById(R.id.layout_profile);
        layout_more = (LinearLayout) findViewById(R.id.layout_more);

//        Click Listener
        iv_notifaiction.setOnClickListener(this);
        layout_home.setOnClickListener(this);
        layout_saved.setOnClickListener(this);
        layout_following.setOnClickListener(this);
        layout_profile.setOnClickListener(this);
        tvChangePassword.setOnClickListener(this);
        tvAboutUs.setOnClickListener(this);
        tvFaq.setOnClickListener(this);
        tvPrivacyPolicy.setOnClickListener(this);
        tvTAndC.setOnClickListener(this);
        tvContactUs.setOnClickListener(this);
        tvRateUs.setOnClickListener(this);
        tvLogout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.tvChangePassword:
                Intent intent = new Intent(MoreActivity.this, ChangePasswordActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                break;

            case R.id.tvAboutUs:
                Intent intent1 = new Intent(MoreActivity.this, AboutUsActivity.class);
                startActivity(intent1);
                overridePendingTransition(0, 0);
                break;

            case R.id.tvFaq:
                Intent intent3 = new Intent(MoreActivity.this, FAQActivity.class);
                startActivity(intent3);
                overridePendingTransition(0, 0);
                break;

            case R.id.tvPrivacyPolicy:
                Intent intent4 = new Intent(MoreActivity.this, PrivacyPolicyActivity.class);
                startActivity(intent4);
                overridePendingTransition(0, 0);
                break;

            case R.id.tvTAndC:
                Intent intent5 = new Intent(MoreActivity.this, TermsAndConditionsActivity.class);
                startActivity(intent5);
                overridePendingTransition(0, 0);
                break;

            case R.id.tvContactUs:
                Intent intent6 = new Intent(MoreActivity.this, ContactUsActivity.class);
                startActivity(intent6);
                overridePendingTransition(0, 0);
                break;

            case R.id.tvRateUs:
                break;

            case R.id.tvLogout:
                Intent intent7 = new Intent(MoreActivity.this, LoginActivity.class);
                startActivity(intent7);
                overridePendingTransition(0, 0);
                finish();
                Toast.makeText(this, "Logout successfully", Toast.LENGTH_SHORT).show();
                break;

            case R.id.layout_home:
                Intent intent9 = new Intent(MoreActivity.this, HomeActivity.class);
                startActivity(intent9);
                overridePendingTransition(0, 0);
                finish();
                break;

            case R.id.layout_saved:
                Intent intent10 = new Intent(MoreActivity.this, SavedActivity.class);
                startActivity(intent10);
                overridePendingTransition(0, 0);
                finish();
                break;

            case R.id.layout_following:
                Intent followingIntent = new Intent(MoreActivity.this, FollowingActivity.class);
                startActivity(followingIntent);
                overridePendingTransition(0, 0);
                finish();
                break;

            case R.id.layout_profile:
                Intent intent8 = new Intent(MoreActivity.this, ProfileActivity.class);
                startActivity(intent8);
                overridePendingTransition(0, 0);
                finish();
                break;

            case R.id.iv_notifaiction:
                Intent intent2 = new Intent(MoreActivity.this, ScoopActivity.class);
                startActivity(intent2);
                overridePendingTransition(0, 0);
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(MoreActivity.this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // To clean up all activities
        startActivity(intent);
        overridePendingTransition(0, 0);

        try {
            View view = this.getCurrentFocus();
            if (view != null) {
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finish();
    }
}
