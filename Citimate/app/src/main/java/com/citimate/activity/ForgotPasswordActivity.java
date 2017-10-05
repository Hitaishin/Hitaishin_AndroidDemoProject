package com.citimate.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.citimate.R;

public class ForgotPasswordActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvCreatePassword, tvBackToSignin;
    private EditText etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
        initialization();
    }

    //    Views Id Initialize Method
    public void initialization() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.color_statusBar));
        }

//        EditText Id
        etEmail = (EditText) findViewById(R.id.etEmail);

//        TextView Id
        tvCreatePassword = (TextView) findViewById(R.id.tvCreatePassword);
        tvBackToSignin = (TextView) findViewById(R.id.tvBackToSignin);

//        Click Listener
        tvCreatePassword.setOnClickListener(this);

//        Spinner Setup
        SpannableString ss = new SpannableString(getResources().getString(R.string.back_to_signIn));

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                finish();
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(ContextCompat.getColor(ForgotPasswordActivity.this, R.color.colorWhite));
                ds.setUnderlineText(true);
            }
        };

        ss.setSpan(clickableSpan, 17, 24, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvBackToSignin.setText(ss);
        tvBackToSignin.setMovementMethod(LinkMovementMethod.getInstance());
    }

    //    User Validation
    private boolean validateFields() {
        if (etEmail.getText().toString().trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter username and password", Toast.LENGTH_LONG).show();
            etEmail.requestFocus();
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvCreatePassword:
                Toast.makeText(this, "In progress", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
