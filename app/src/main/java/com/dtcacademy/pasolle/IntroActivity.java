package com.dtcacademy.pasolle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class IntroActivity extends AppCompatActivity {

    LinearLayout Footer;
    ImageView Header;
    RelativeLayout relativeLayout;
    Animation fromBottom, fromTop, fadeIn;
    int [] bg_header = null;
    int[] bg_footer = null;
    int[] bg_intro = null;

    SliderAdapter sliderAdapter;

    TextView desc;
    TabLayout tabIndikator;
    Button btnGetStarted;
    Button Skip;
    LottieAnimationView Boom;

    ImageButton btnNext;
    int position = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro_view_pager);

        //untuk membuat layar full screen
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
        getWindow().setStatusBarColor(Color.TRANSPARENT);




        //when this activity is about to be launch we need to check if its opened before or not

        if (restorePrefData()) {
            Intent introKota = new Intent(getApplicationContext(), SignIn.class);
            startActivity(introKota);
            finish();
        }

        /*deklasrasi di header dan footer*/
        Footer = (LinearLayout) findViewById(R.id.footer);
        Header = (ImageView) findViewById(R.id.toolbar);
        relativeLayout = findViewById(R.id.relative_layout);

        //Deklarasi Animation dan set Animation
        fromBottom = AnimationUtils.loadAnimation(this, R.anim.frombottom);
        fromTop = AnimationUtils.loadAnimation(this, R.anim.fromtop);
        fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);


        //ini untuk button next
        btnNext = findViewById(R.id.btn_next);
        // ini tab indikator buble
        tabIndikator = findViewById(R.id.tab_indikator);
        //ini Get Started
        btnGetStarted = findViewById(R.id.btn_getStar);
        btnGetStarted.setVisibility(View.INVISIBLE);
        //ini Skip
        Skip = findViewById(R.id.skip);
        //ini Animation Lottie Boom
        Boom = findViewById(R.id.boom_lottie);
        Boom.setVisibility(View.INVISIBLE);


        Header.setAnimation(fromTop);
        Footer.setAnimation(fromBottom);

        /*Untuk TypeFace textView Keterangan menjadi poppins*/
        String poppins = "poppins.otf";
        desc = findViewById(R.id.description);
        Typeface font_poppins = Typeface.createFromAsset(getAssets(), poppins);
        desc.setTypeface(font_poppins);


        //fill list screen
        final List<SliderItem> mList = new ArrayList<>();
        mList.add(new SliderItem("Liburan", R.drawable.slider1));
        mList.add(new SliderItem("Cek Lokasi Wisata dan Hotel", R.drawable.slider3));
        mList.add(new SliderItem("Nikmati berbagai fitur dan temukan experience baru", R.drawable.slider2));
        // setup view pager
        final ViewPager screenPager = findViewById(R.id.view_pager);
        sliderAdapter = new SliderAdapter(this, mList);
        screenPager.setAdapter(sliderAdapter);

        //setup tablayout dengan tab indikator

        tabIndikator.setupWithViewPager(screenPager);


        //untuk mengatur behaviour button next

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                position = screenPager.getCurrentItem();

                if (position < mList.size()) {
                    position++;
                    screenPager.setCurrentItem(position);


                }
                if (position == mList.size() - 1) {
                    //ketika mencapai screen terakhr

                    LoadLastScreen();

                }

            }
        });

        //Array background
        final int[] background_footer = {

                R.drawable.footer_intro1,
                R.drawable.footer_intro2,
                R.drawable.footer_intro3

        };
        bg_footer = background_footer;
        final int[] background_header = {
                R.drawable.header_intro1,
                R.drawable.header_intro2,
                R.drawable.header_intro3,
        };
        bg_header = background_header;
        final int[] background_intro = {
                R.drawable.bg_intro1,
                R.drawable.bg_intro2,
                R.drawable.bg_intro3
        };
        bg_intro = background_intro;

        final String[] description = {
                "Bepergian ke tempat wisata seru wilayah Sulawesi Selatan\nMenjadi lebih mudah",
                "Akses lokasi wisata dan hotel dengan cepat untuk kepuasan Anda",
                "Mulai sekarang! dan dapatkan berbagai penawaran terbaik untuk Anda"

        };

        //tablayout add change listener

        tabIndikator.addOnTabSelectedListener(new TabLayout.BaseOnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                if (tab.getPosition() == mList.size() - 1) {
                    LoadLastScreen();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        screenPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {

                if(position< (sliderAdapter.getCount()-1)&& position < (bg_footer.length-1)&& position < (bg_header.length-1)&& position < (bg_intro.length-1)) {

                    relativeLayout.setBackgroundResource(background_intro[position]);
                    Header.setImageResource(background_header[position]);
                    Footer.setBackgroundResource(background_footer[position]);
                    desc.setText(description[position]);

                }else{
                    relativeLayout.setBackgroundResource(background_intro[background_intro.length-1]);
                    Header.setImageResource(background_header[background_header.length-1]);
                    Footer.setBackgroundResource(background_footer[background_footer.length-1]);
                    desc.setText(description[description.length-1]);
                }

                position++;

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //Skip Button Click Listener
        Skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntroActivity.this, IntroKotaActivity.class);
                startActivity(intent);

                savePrefdata();
                finish();
            }
        });

        //Get Started Button Click Listener
        btnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(IntroActivity.this, IntroKotaActivity.class);
                startActivity(intent);

                //also we need to save a boolean value to storage so next time when the user run the app
                //we could know that he is already checked the intro screen activity
                //i'm going to use shared preferences to that process

                savePrefdata();
                finish();
            }
        });

    }

    private void LoadLastViewPager() {
    }

    private boolean restorePrefData() {

        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        Boolean isIntroActivityOpenedBefore = pref.getBoolean("isIntroOpened", false);
        return isIntroActivityOpenedBefore;
    }

    private void savePrefdata() {


        SharedPreferences pref = getApplicationContext().getSharedPreferences("myPrefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putBoolean("isIntroOpened", true);
        editor.commit();
    }

    private void LoadLastScreen() {

        btnGetStarted.setVisibility(View.VISIBLE);
        btnNext.setVisibility(View.INVISIBLE);
        Skip.setVisibility(View.INVISIBLE);
        tabIndikator.setVisibility(View.INVISIBLE);
        Boom.setVisibility(View.VISIBLE);
        btnGetStarted.setAnimation(fadeIn);
        Boom.setAnimation(fadeIn);

    }


}
