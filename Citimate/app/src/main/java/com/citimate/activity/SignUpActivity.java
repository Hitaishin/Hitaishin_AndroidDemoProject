package com.citimate.activity;

import android.content.Intent;
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
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.citimate.R;
import com.citimate.constant.Constant;

public class SignUpActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etUserName, etEmail, etMobileNumber, etPassword, etConfirmPassword;
    private TextView tvAlreadyAccount, tvSignUp, tvAgree;
    private CheckBox cbTerms;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        initialization();
        spinner();
    }

    //    Views Id Initialize Method
    public void initialization() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.color_statusBar));
        }

//        EditText Id
        etUserName = (EditText) findViewById(R.id.etUserName);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etMobileNumber = (EditText) findViewById(R.id.etMobileNumber);
        etPassword = (EditText) findViewById(R.id.etPassword);
        etConfirmPassword = (EditText) findViewById(R.id.etConfirmPassword);

//        TextView Id
        tvAlreadyAccount = (TextView) findViewById(R.id.tvAlreadyAccount);
        tvAgree = (TextView) findViewById(R.id.tvAgree);
        tvSignUp = (TextView) findViewById(R.id.tvSignUp);

//        CheckBox Id
        cbTerms = (CheckBox) findViewById(R.id.cbTerms);

//        Click Listener
        tvAlreadyAccount.setOnClickListener(this);
        tvSignUp.setOnClickListener(this);
    }

    //    Spinner Setup Method
    private void spinner() {
        SpannableString ss = new SpannableString(getResources().getString(R.string.Have_an_account));

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                finish();
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(ContextCompat.getColor(SignUpActivity.this, R.color.colorWhite));
                ds.setUnderlineText(true);
            }
        };

        ss.setSpan(clickableSpan, 24, 31, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvAlreadyAccount.setText(ss);

        tvAlreadyAccount.setMovementMethod(LinkMovementMethod.getInstance());

        SpannableString ss1 = new SpannableString(getResources().getString(R.string.i_agree));
        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                Intent intent = new Intent(SignUpActivity.this, TermsAndConditionsActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
            }

            @Override
            public void updateDrawState(TextPaint ds) {
                super.updateDrawState(ds);
                ds.setColor(ContextCompat.getColor(SignUpActivity.this, R.color.colorWhite));
                ds.setUnderlineText(true);
            }
        };

        ss1.setSpan(clickableSpan1, 12, 32, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvAgree.setText(ss1);
        tvAgree.setMovementMethod(LinkMovementMethod.getInstance());
    }

    //    User Validation Method
    private boolean validateFields() {

        if (etUserName.getText().toString().trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter username", Toast.LENGTH_LONG).show();
            etUserName.requestFocus();
            return false;
        }
        if (etMobileNumber.getText().toString().trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter mobile number", Toast.LENGTH_LONG).show();
            etMobileNumber.requestFocus();
            return false;
        }
        if (etEmail.getText().toString().trim().isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(etEmail.getText().toString().trim()).matches()) {
            Toast.makeText(getApplicationContext(), "Please enter a valid email address", Toast.LENGTH_LONG).show();
            etEmail.requestFocus();
            return false;
        }
        if (!Constant.passwordValidator(etPassword.getText().toString().trim())) {
            Toast.makeText(getApplicationContext(), " Please enter password between 8 to 16 alphanumeric characters", Toast.LENGTH_SHORT).show();
            etPassword.requestFocus();
            return false;
        }
        if (!etConfirmPassword.getText().toString().trim().equals(etPassword.getText().toString().trim())) {
            Toast.makeText(getApplicationContext(), "Password Mismatch", Toast.LENGTH_SHORT).show();
            etConfirmPassword.requestFocus();
            return false;
        }

        if (!cbTerms.isChecked()) {
            Toast.makeText(getApplicationContext(), "Please agreed to Terms of Use", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.tvSignUp:
                Toast.makeText(this, "In progress", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
