package com.dtcacademy.pasolle;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ForgotPassword extends AppCompatActivity {

    TextView txtForgotPassword, txtKetForgotPassword, txtOr;
    Button Reset, goToSignIn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgot_password);

        txtForgotPassword = findViewById(R.id.forgot_password);
        txtKetForgotPassword = findViewById(R.id.ket_forgotpassword);
        txtOr = findViewById(R.id.or);
        Reset = findViewById(R.id.reset);
        goToSignIn = findViewById(R.id.goToSignIn);

        String metropolis = "metropolis.otf";
        Typeface font_metropolis = Typeface.createFromAsset(getAssets(),metropolis);

        txtForgotPassword.setTypeface(font_metropolis);
        txtKetForgotPassword.setTypeface(font_metropolis);
        txtOr.setTypeface(font_metropolis);
        Reset.setTypeface(font_metropolis);
        goToSignIn.setTypeface(font_metropolis);

        Reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signIn = new Intent(ForgotPassword.this, ResetPassword.class);
                startActivity(signIn);

            }
        });
        goToSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signIn = new Intent(ForgotPassword.this, SignIn.class);
                startActivity(signIn);
            }
        });


    }
}
