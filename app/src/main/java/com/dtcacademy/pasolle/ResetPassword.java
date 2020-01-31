package com.dtcacademy.pasolle;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResetPassword extends AppCompatActivity {

    TextView txtResetYourPassword, txtKetResetPassword;
    Button Change, goToSignIn;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reset_password);

        txtResetYourPassword = findViewById(R.id.resetyour_password);
        txtKetResetPassword = findViewById(R.id.ket_resetpassword);
        Change = findViewById(R.id.change);
        goToSignIn = findViewById(R.id.goToSignIn);

        String metropolis = "metropolis.otf";
        Typeface font_metropolis = Typeface.createFromAsset(getAssets(),metropolis);

        txtResetYourPassword.setTypeface(font_metropolis);
        txtKetResetPassword.setTypeface(font_metropolis);
        Change.setTypeface(font_metropolis);
        goToSignIn.setTypeface(font_metropolis);

        Change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signIn = new Intent(ResetPassword.this, SignIn.class);
                startActivity(signIn);
            }
        });
        goToSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signIn = new Intent(ResetPassword.this, SignIn.class);
                startActivity(signIn);
            }
        });


    }
}
