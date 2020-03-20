package com.example.androidmaterialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindAnim;
import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashScreen extends AppCompatActivity {

    private static final int SCREEN_DELAY = 3000;

    @BindView(R.id.imageView)
    ImageView bauetLogoImageView;

    @BindView(R.id.textView2)
    TextView bauetNameTextView;

    @BindView(R.id.textView3)
    TextView messageTextView;

    @BindAnim(R.anim.top_animation)
    Animation topAnimation;

    @BindAnim(R.anim.bottom_animation)
    Animation bottomAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_spalash_screen);
        ButterKnife.bind(this);

        bauetLogoImageView.setAnimation(topAnimation);
        messageTextView.setAnimation(bottomAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this,DashboardActivity.class));
                finish();
            }
        },SCREEN_DELAY);
    }
}
