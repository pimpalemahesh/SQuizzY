package com.myinnovation.squizzy.Activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.myinnovation.squizzy.R;

public class RegisterActivity extends AppCompatActivity {

    FirebaseAuth mAuth;
    String username = "", email = "", password = "", cpassword = "", mobile = "", code = "";
    EditText _username, _mobile, _email, _password, _cpassword, _code;
    Button _register, _gotoLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        InitializeFields();


        _register.setOnClickListener(v -> {
            validateFields();
        });

        _gotoLogin.setOnClickListener(v -> {
            startActivity(new Intent(RegisterActivity.this, LoginActivity.class).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK));
        });
    }

    private void validateFields() {
        username = _username.getText().toString();
        email = _email.getText().toString();
        password = _password.getText().toString();
        cpassword = _cpassword.getText().toString();
        mobile = _mobile.getText().toString();
        code = _code.getText().toString();

        // username check
        if (TextUtils.isEmpty(username)) {
            _username.setError("Required");
            return;
        }


        // email check
        if (TextUtils.isEmpty(email)) {
            _email.setError("Required");
            return;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Toast.makeText(this, "Check your email again...", Toast.LENGTH_LONG).show();
            return;
        }

        // mobile check
        if (TextUtils.isEmpty(mobile)) {
            _mobile.setError("Required");
            return;
        } else if (!Patterns.PHONE.matcher(mobile).matches()) {
            Toast.makeText(this, "Wrong Mobile Number", Toast.LENGTH_LONG).show();
            return;
        } else if (mobile.length() != 10) {
            Toast.makeText(this, "Mobile Length should be 10 only.", Toast.LENGTH_LONG).show();
            return;
        }

        // password check
        if (TextUtils.isEmpty(password)) {
            _password.setError("Required");
            return;
        } else if (password.length() < 8) {
            Toast.makeText(this, "Password Length should be 8 or greater than 8.", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(cpassword)) {
            _cpassword.setError("Required");
            return;
        } else if (cpassword.length() < 8) {
            Toast.makeText(this, "Password Length should be 8 or greater than 8.", Toast.LENGTH_LONG).show();
            return;
        } else if (!cpassword.equals(password)) {
            Toast.makeText(this, "Password not matched", Toast.LENGTH_LONG).show();
            return;
        }

        // code check
        if (TextUtils.isEmpty(code)) {
            _code.setError("Required");
            return;
        }

        registerUser();
    }

    private void registerUser() {
        Intent intent = new Intent(RegisterActivity.this, OtpVerificationActivity.class);
        intent.putExtra("USERNAME", username);
        intent.putExtra("EMAIL", email);
        intent.putExtra("PASSWORD", password);
        intent.putExtra("MOBILE", mobile);
        intent.putExtra("CODE", code);
        startActivity(intent);
    }

    private void InitializeFields() {
        mAuth = FirebaseAuth.getInstance();
        _username = findViewById(R.id.username);
        _mobile = findViewById(R.id.mobile);
        _email = findViewById(R.id.email);
        _password = findViewById(R.id.password);
        _cpassword = findViewById(R.id.c_password);
        _code = findViewById(R.id.code);
        _register = findViewById(R.id.register);
        _gotoLogin = findViewById(R.id.go_to_login);
    }



    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            startActivity(new Intent(RegisterActivity.this, MainActivity.class));
            finish();
        }
    }
}