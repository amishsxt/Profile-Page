package com.example.amishprofilepage.Views;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

import com.example.amishprofilepage.R;
import com.example.amishprofilepage.Views.Home.HomeActivity;
import com.example.amishprofilepage.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding xml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //root
        xml = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(xml.getRoot());

        // Fade-in animation
        Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        fadeInAnimation.setDuration(800);

        fadeInAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                navigate();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        xml.splashText.startAnimation(fadeInAnimation);
    }

    public void navigate(){
        Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}