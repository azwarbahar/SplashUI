package com.dtcacademy.pasolle;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {
    TextView headerSplash;
    ImageView pasolle, pasolleLontara, bubbleSplash, bubbleSplash1, bubbleSplash2 ;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /*transparant toolbar*/
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        setContentView(R.layout.splash_screen);

        /*Untuk TypeFace textView Keterangan menjadi poppins*/
        String poppins = "poppins.otf";
        headerSplash = findViewById(R.id.header_splash);
        Typeface font_poppins = Typeface.createFromAsset(getAssets(), poppins);
        headerSplash.setTypeface(font_poppins);


                                /*Animation Splash Screen*/
        //LOGO
        pasolle = findViewById(R.id.pasolle);
        Animation fadein = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        pasolle.startAnimation(fadein);
        //BUBBLE
        bubbleSplash = findViewById(R.id.bubble);
        Animation fadein2 = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        bubbleSplash.startAnimation(fadein2);
        //BUBBLE SPLASH 1
        bubbleSplash1 = findViewById(R.id.bubble_splash1);
        Animation fadein3 = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        bubbleSplash1.startAnimation(fadein3);
        //BUBBLE SPLASH 1
        bubbleSplash2 = findViewById(R.id.bubble_splash2);
        Animation fadein4 = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        bubbleSplash2.startAnimation(fadein4);
        //PASOLLE LONTARA DAN HEADER SPLASH
        pasolleLontara = findViewById(R.id.pasolle_lontara);
        headerSplash = findViewById(R.id.header_splash);
        Animation fadein5 = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        pasolleLontara.startAnimation(fadein5);
        headerSplash.startAnimation(fadein5);


        /*Menjalankan Splash Screen dalam beberapa detik*/
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashScreen.this, IntroActivity.class);
                startActivity(intent);

                /*Splash Screen Hilang*/
                finish();
            }
        }, 4000);

//        /*Menjalankan Splash Screen dalam beberapa detik cara kedua*/
//        Thread thread = new Thread() {
//            @Override
//            public void run() {
//                try {
//                    sleep(7000);
//
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                } finally {
//                    /*apa yang terjadi*/
//                    animationDrawable.setEnterFadeDuration(5000);
//                    animationDrawable.setExitFadeDuration(2000);
//
//                    /*Splash Screen Hilang*/
//                    finish();
//                    startActivity(new Intent(SplashScreen.this, IntroActivity.class));
//                }
//            }
//        };

    }

}
