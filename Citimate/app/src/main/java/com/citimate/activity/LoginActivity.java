package com.citimate.activity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.citimate.R;
import com.citimate.constant.Constant;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etUserName, etPassword;
    private TextView tvLogin, tvSignUp, tvLoginWithFacebook, tvForgotPassword, tvGuest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initialization();
    }

    //    Views Id Initialize Method
    public void initialization() {
//        EditText Id
        etUserName = (EditText) findViewById(R.id.etUserName);
        etPassword = (EditText) findViewById(R.id.etPassword);

//        TextView Id
        tvLogin = (TextView) findViewById(R.id.tvLogin);
        tvSignUp = (TextView) findViewById(R.id.tvSignUp);
        tvLoginWithFacebook = (TextView) findViewById(R.id.tvLoginWithFacebook);
        tvForgotPassword = (TextView) findViewById(R.id.tvForgotPassword);
        tvGuest = (TextView) findViewById(R.id.tvGuest);

//        Click Listener
        tvLogin.setOnClickListener(this);
        tvSignUp.setOnClickListener(this);
        tvLoginWithFacebook.setOnClickListener(this);
        tvForgotPassword.setOnClickListener(this);
        tvGuest.setOnClickListener(this);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.color_statusBar));
        }
    }

    //    User Login Validation
    private boolean validateFields() {
        if (etUserName.getText().toString().trim().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter username and password", Toast.LENGTH_LONG).show();
            etUserName.requestFocus();
            return false;
        }
        if (!Constant.passwordValidator(etPassword.getText().toString().trim())) {
            Toast.makeText(getApplicationContext(), "Please enter password between 8 to 16 alphanumeric characters", Toast.LENGTH_SHORT).show();
            etPassword.requestFocus();
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvSignUp:
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
                overridePendingTransition(0, 0);
                break;

            case R.id.tvForgotPassword:
                Intent intent1 = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
                startActivity(intent1);
                overridePendingTransition(0, 0);
                break;

            case R.id.tvGuest:
                Intent intent3 = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent3);
                overridePendingTransition(0, 0);
                break;

            case R.id.tvLogin:
                Intent loginIntent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(loginIntent);
                overridePendingTransition(0, 0);
                Toast.makeText(this, "Login successfully", Toast.LENGTH_SHORT).show();
                break;

            case R.id.tvLoginWithFacebook:
                Intent fbLogin = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(fbLogin);
                overridePendingTransition(0, 0);
                Toast.makeText(this, "Login successfully", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
