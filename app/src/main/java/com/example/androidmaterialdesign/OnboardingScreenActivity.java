package com.example.androidmaterialdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class OnboardingScreenActivity extends AppCompatActivity {

    ViewPager viewPager ;
    LinearLayout dotsLinearLayout;

    ArrayList<Integer> images;
    ArrayList<Integer> headings;
    ArrayList<Integer> description;

    Button skipButton, nextButton, letsGetStartedButton;

    SliderViewPagerAdapter adapter;

    TextView[] dotsTextView;

    Animation animation;

    int currentPosition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        images = new ArrayList<>();
        headings = new ArrayList<>();
        description = new ArrayList<>();

        skipButton = findViewById(R.id.skipSlideButtonId);
        nextButton = findViewById(R.id.nextSlideButtonId);
        letsGetStartedButton = findViewById(R.id.lets_get_startedBtnId);

        images.add(R.drawable.first_slide_image);
        images.add(R.drawable.second_slide_image);
        images.add(R.drawable.third_slide_image);
        images.add(R.drawable.fourth_slide_image);

        headings.add(R.string.first_slide_title);
        headings.add(R.string.second_slide_title);
        headings.add(R.string.third_slide_title);
        headings.add(R.string.fourth_slide_title);

        description.add(R.string.first_slide_disc);
        description.add(R.string.second_slide_disc);
        description.add(R.string.third_slide_disc);
        description.add(R.string.first_slide_disc);

        viewPager = findViewById(R.id.sliderId);
        dotsLinearLayout = findViewById(R.id.dotsLayout);

        adapter = new SliderViewPagerAdapter(this,images,headings,description);

        viewPager.setAdapter(adapter);

        addDots(0);

        viewPager.addOnPageChangeListener(changeListener);
    }

    private void addDots(int position) {
        dotsTextView = new TextView[headings.size()];
        dotsLinearLayout.removeAllViews();

        for (int i = 0; i < dotsTextView.length; i++) {
            dotsTextView[i] = new TextView(this);
            dotsTextView[i].setText(Html.fromHtml("&#8226;"));
            dotsTextView[i].setTextSize(35);

            dotsLinearLayout.addView(dotsTextView[i]);
        }

        if (dotsTextView.length>0){
            dotsTextView[position].setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        }

    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            currentPosition = position;
            addDots(position);
            if (position<=2){
                letsGetStartedButton.setVisibility(View.INVISIBLE);
                skipButton.setVisibility(View.VISIBLE);
                nextButton.setVisibility(View.VISIBLE);
            }else {
                skipButton.setVisibility(View.INVISIBLE);
                nextButton.setVisibility(View.INVISIBLE);
                animation = AnimationUtils.loadAnimation(OnboardingScreenActivity.this, R.anim.slide_button_animation);
                letsGetStartedButton.setAnimation(animation);
                letsGetStartedButton.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    public void skipSlide(View view) {
        startActivity(new Intent(OnboardingScreenActivity.this,LoginActivity.class));
        finish();
    }

    public void nextSlide(View view) {
        viewPager.setCurrentItem(currentPosition+1);
    }

    public void lesGetStarted(View view) {
        startActivity(new Intent(OnboardingScreenActivity.this,LoginActivity.class));
        finish();
    }
}
