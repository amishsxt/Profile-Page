package com.example.amishprofilepage.Views;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

import com.example.amishprofilepage.Model.RoomDB.AppDatabase;
import com.example.amishprofilepage.Model.RoomDB.User;
import com.example.amishprofilepage.R;
import com.example.amishprofilepage.Views.Home.HomeActivity;
import com.example.amishprofilepage.databinding.ActivitySplashBinding;

import java.util.ArrayList;
import java.util.List;

public class SplashActivity extends AppCompatActivity {

    private ActivitySplashBinding xml;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //root
        xml = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(xml.getRoot());

        // Check the database and fill data if empty
        checkDB();

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

    public void checkDB(){
        AppDatabase appDatabase = AppDatabase.getDB(this);
        int count = appDatabase.userDao().getRecordCount();

        if(count==0){
            List<String> nameList = new ArrayList<>(List.of(
                    "Emma", "Liam", "Olivia", "Noah", "Ava", "Isabella", "Sophia", "Jackson", "Aiden", "Lucas",
                    "Oliver", "Caden", "Ethan", "Michael", "Elizabeth", "Mia", "Charlotte", "Abigail", "Camila", "Emily",
                    "Grace", "Madison", "Avery", "Sofia", "Scarlett", "James", "Benjamin", "Henry", "Alexander", "Sebastian",
                    "Elijah", "David", "William", "Joseph", "Matthew", "Samuel", "Daniel", "Jackson", "Logan", "Liam", "Mason",
                    "John", "David", "James", "Oliver", "Joseph", "Michael", "Thomas", "William"
            ));

            for (String name : nameList) {
                appDatabase.userDao().insertRecord(new User(name));
            }
        }
    }
}