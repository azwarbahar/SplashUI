package com.dtcacademy.pasolle;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity {
    TextView signUpTxt;
    Button backSignIn;
    Button signUp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);

        signUpTxt = findViewById(R.id.sign_up_txt);
        String metropolis = "metropolis.otf";
        Typeface font_metropolis = Typeface.createFromAsset(getAssets(), metropolis);
        signUpTxt.setTypeface(font_metropolis);

        backSignIn = findViewById(R.id.sign_in);
        signUp = findViewById(R.id.btn_signup);

        backSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent signIn = new Intent(SignUp.this, SignIn.class);
                startActivity(signIn);
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent welcome = new Intent(SignUp.this, SignIn.class);
                startActivity(welcome);
            }
        });
    }
}
