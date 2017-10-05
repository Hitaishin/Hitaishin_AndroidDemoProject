package com.citimate.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.citimate.R;

public class SplashActivity extends AppCompatActivity {

    // Splash screen timer
    private static int SPLASH_TIME_OUT = 3000;
    private boolean prefValue;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // If the Android version is lower than Jellybean, use this call to hide
        // the status bar.
        if (Build.VERSION.SDK_INT > 16) {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }


        setContentView(R.layout.activity_splash);
        context = this;
        new Handler().postDelayed(new Runnable() {

            /*
             * Showing splash screen with a timer. This will be useful when you
             * want to show case your app logo / company
             */

            @Override
            public void run() {
                // This method will be executed once the timer is over
                // Start app main activity
                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
                boolean firstRun = prefs.getBoolean("FirstRun", true);
                if (firstRun) {
                    SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(SplashActivity.this).edit();
                    editor.putBoolean("FirstRun", false);
                    editor.apply();
                    Intent intent = new Intent(SplashActivity.this, TutorialActivty.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent myIntent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(myIntent);
                    finish();
                }
            }
        }, SPLASH_TIME_OUT);
    }
}
