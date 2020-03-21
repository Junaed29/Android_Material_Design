package com.example.androidmaterialdesign;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_spalash_screen);
        ButterKnife.bind(this);

        bauetLogoImageView.setAnimation(topAnimation);
        messageTextView.setAnimation(bottomAnimation);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, LoginActivity.class);
                startActivity(intent);
                finish();
                /* For Shared TransitionAnimation
                 * Pair[] pairs = new Pair[2];
                 *                 pairs[0] = new Pair<>(bauetLogoImageView, "logo_image");
                 *                 pairs[1] = new Pair<>(bauetNameTextView, "logo_title");
                 *
                 *                 if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                 *                     ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SplashScreen.this, pairs);
                 *                     startActivity(intent,options.toBundle());
                 *                     finish();
                 *                 }else {
                 *                     startActivity(intent);
                 *                     finish();
                 *                 }
                 */
            }
        }, SCREEN_DELAY);
    }
}
