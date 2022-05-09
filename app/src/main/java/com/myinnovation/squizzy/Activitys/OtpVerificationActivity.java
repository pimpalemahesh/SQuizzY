package com.myinnovation.squizzy.Activitys;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.myinnovation.squizzy.R;
import com.myinnovation.squizzy.databinding.ActivityOtpVerificationBinding;

import java.util.concurrent.TimeUnit;

public class OtpVerificationActivity extends AppCompatActivity {

    ActivityOtpVerificationBinding binding;
    String verificationID = "";
    String username = "", email = "", password = "", mobile = "", code = "";
    FirebaseAuth mAuth;
    String userOTP = "";
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOtpVerificationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        InitializeFields();
        sendVerificationCode(mobile);

        binding.otp1.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if(binding.otp1.getText().toString().length()==1)     //size as per your requirement
                {
                    binding.otp2.requestFocus();
                }
            }
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // TODO Auto-generated method stub

            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

        });

        binding.otp2.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if(binding.otp2.getText().toString().length()==1)     //size as per your requirement
                {
                    binding.otp3.requestFocus();
                }
            }
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // TODO Auto-generated method stub

            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

        });

        binding.otp3.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if(binding.otp3.getText().toString().length()==1)     //size as per your requirement
                {
                    binding.otp4.requestFocus();
                }
            }
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // TODO Auto-generated method stub

            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

        });

        binding.otp4.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if(binding.otp4.getText().toString().length()==1)     //size as per your requirement
                {
                    binding.otp5.requestFocus();
                }
            }
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // TODO Auto-generated method stub

            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

        });

        binding.otp5.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if(binding.otp5.getText().toString().length()==1)     //size as per your requirement
                {
                    binding.otp6.requestFocus();
                }
            }
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // TODO Auto-generated method stub

            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

        });

        binding.otp6.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start,int before, int count)
            {
                // TODO Auto-generated method stub
                if(binding.otp6.getText().toString().length()==1)     //size as per your requirement
                {
                    binding.verifyOtp.requestFocus();
                }
            }
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
                // TODO Auto-generated method stub

            }

            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }

        });

        binding.verifyOtp.setOnClickListener(v -> {
            userOTP = binding.otp1.getText().toString() + binding.otp2.getText().toString() + binding.otp3.getText().toString() + binding.otp4.getText().toString() + binding.otp5.getText().toString() + binding.otp6.getText().toString();
            if (TextUtils.isEmpty(userOTP) || userOTP.length() != 6) {
                Toast.makeText(OtpVerificationActivity.this, "Wrong OTP", Toast.LENGTH_SHORT).show();
            } else
                verifyCode(userOTP.trim());
        });
    }

    private void InitializeFields() {
        mAuth = FirebaseAuth.getInstance();
        dialog = new ProgressDialog(this);
        dialog.setTitle("Wait Verification is important!!!");
        dialog.setIcon(R.drawable.ic_warning);
        dialog.setMessage("We are going to verify you whether you are human or not just for convenience");
        dialog.setCancelable(false);
        dialog.setCanceledOnTouchOutside(false);
        dialog.show();
        if (getIntent() != null) {
            username = getIntent().getStringExtra("USERNAME");
            email = getIntent().getStringExtra("EMAIL");
            mobile = getIntent().getStringExtra("MOBILE");
            password = getIntent().getStringExtra("PASSWORD");
            code = getIntent().getStringExtra("code");
        }
    }

    private void sendVerificationCode(String phoneNumber) {
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+91" + phoneNumber)  // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallbacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }

    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
            mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential credential) {
            final String code = credential.getSmsCode();
            if (code != null) {
                verifyCode(code);
            }
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            Toast.makeText(OtpVerificationActivity.this, "Verification Failed " + e.getMessage(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCodeSent(@NonNull String s,
                               @NonNull PhoneAuthProvider.ForceResendingToken token) {
            super.onCodeSent(s, token);
            verificationID = s;
            dialog.dismiss();
            Toast.makeText(OtpVerificationActivity.this, "OTP is successfully sent check your inbox", Toast.LENGTH_LONG).show();
            binding.verifyOtp.setEnabled(true);
            binding.bar.setVisibility(View.INVISIBLE);
        }
    };

    private void verifyCode(String Code) {
        binding.bar.setVisibility(View.VISIBLE);
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationID, Code);
        signInByCredentials(credential);
    }

    private void signInByCredentials(PhoneAuthCredential credential) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signInWithCredential(credential)
                .addOnCompleteListener(new OnCompleteListener() {
                    @Override
                    public void onComplete(@NonNull Task task) {
                        if (task.isSuccessful()) {
                            binding.bar.setVisibility(View.INVISIBLE);
                            Toast.makeText(OtpVerificationActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(OtpVerificationActivity.this, MainActivity.class));
                        }

                    }
                });
    }
}