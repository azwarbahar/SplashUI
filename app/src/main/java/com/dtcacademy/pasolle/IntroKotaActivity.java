package com.dtcacademy.pasolle;

import android.animation.ArgbEvaluator;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class IntroKotaActivity extends AppCompatActivity {
    Button login;
    ViewPager viewPager;
    SliderKotaAdapter sliderKotaAdapter;
    List<SliderKotaItem> models;
    Integer[] colors = null;
    ArgbEvaluator argbEvaluator = new ArgbEvaluator();


    TextView introKet;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_kota_view_pager);

        introKet = findViewById(R.id.intro_ket);
        /*Untuk TypeFace textView Keterangan menjadi poppins*/
        String falling = "FallingSkyBd.otf";
        Typeface font_falling = Typeface.createFromAsset(getAssets(), falling);
        introKet.setTypeface(font_falling);

        login = findViewById(R.id.btnLogin);

        models = new ArrayList<>();
        models.add(new SliderKotaItem(R.drawable.makassar, "Makassar", "dikenal sebagai Ujung Pandang adalah ibu kota provinsi Sulawesi Selatan"));
        models.add(new SliderKotaItem(R.drawable.bulukumba, "Bulukumba", "salah satu Daerah Tingkat II di provinsi Sulawesi Selatan, Indonesia"));
        models.add(new SliderKotaItem(R.drawable.maros, "Maros", "wilayah yang berbatasan langsung dengan ibu kota Propinsi Sulawesi"));
        models.add(new SliderKotaItem(R.drawable.gowa, "Gowa", "Daerah Tingkat II di provinsi Sulawesi Selatan, Indonesia. ibu kota kabupaten ini terletak di kota Sungguminasa."));
        models.add(new SliderKotaItem(R.drawable.enrekang, "Enrekang", "salah satu kabupaten di provinsi Sulawesi Selatan, Indonesia. Ibu kota kabupaten ini terletak di Kota Enrekang."));
        models.add(new SliderKotaItem(R.drawable.tana_toraja, "Tana Toraja", "kabupaten di Provinsi Sulawesi Selatan, dengan bupati bernama Ir. Nico Biringkanae. Ibu kota kabupaten ini adalah Makale"));

        sliderKotaAdapter = new SliderKotaAdapter(this, models);

        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(sliderKotaAdapter);
        viewPager.setPadding(130, 0, 130, 0);

        Integer[] colors_temp = {
                getResources().getColor(R.color.color1),
                getResources().getColor(R.color.color2),
                getResources().getColor(R.color.color3),
                getResources().getColor(R.color.color4),
                getResources().getColor(R.color.color5),
                getResources().getColor(R.color.color6),
        };

        colors = colors_temp;

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                if(position< (sliderKotaAdapter.getCount()-1)&& position < (colors.length-1)) {
                    viewPager.setBackgroundColor(
                            (Integer) argbEvaluator.evaluate(
                                    positionOffset,
                                    colors[position],
                                    colors[position + 1]
                            ));
                }else{
                    viewPager.setBackgroundColor(colors[colors.length-1]);
                }

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //Get Started Button Click Listener
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Open Activity

                Intent intent = new Intent(IntroKotaActivity.this, SignIn.class);
                startActivity(intent);
                Intent introKota = new Intent(getApplicationContext(), SignIn.class);
                startActivity(introKota);
                finish();



            }
        });

    }

}
