package com.dtcacademy.pasolle;


import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;


public class Intro extends AppCompatActivity {


    TextView header;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);

        /*Untuk TypeFace textView Keterangan menjadi poppins*/
        String poppins = "poppins.otf";
        header = findViewById(R.id.headings);
        Typeface font_poppins = Typeface.createFromAsset(getAssets(), poppins);
        header.setTypeface(font_poppins);




    }


}

