package com.dtcacademy.pasolle;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class IntroKota extends AppCompatActivity {

    TextView title, description;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_kota);

        /*Untuk TypeFace textView Keterangan menjadi poppins*/
        String poppins = "poppins.otf";
        description = findViewById(R.id.desc);
        title = findViewById(R.id.title);
        Typeface font_poppins = Typeface.createFromAsset(getAssets(), poppins);
        description.setTypeface(font_poppins);
        title.setTypeface(font_poppins);
    }
}
