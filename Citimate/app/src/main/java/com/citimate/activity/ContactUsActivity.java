package com.citimate.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.citimate.R;

public class ContactUsActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv_back_button;
    private TextView tvSendEmail;
    private EditText etSubject, etMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        initialization();
    }

    //    Views Id Initialize Method
    public void initialization() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.color_yellow));
        }

//        EditText Id
        etSubject = (EditText) findViewById(R.id.etSubject);
        etMessage = (EditText) findViewById(R.id.etMessage);
        tvSendEmail = (TextView) findViewById(R.id.tvSendEmail);

//        ImageView Id
        iv_back_button = (ImageView) findViewById(R.id.iv_back_button);

//        Click Listener
        tvSendEmail.setOnClickListener(this);
        iv_back_button.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.tvSendEmail:
                Toast.makeText(this, "In progress", Toast.LENGTH_SHORT).show();

                break;

            case R.id.iv_back_button:
                finish();
                break;
        }
    }
}
