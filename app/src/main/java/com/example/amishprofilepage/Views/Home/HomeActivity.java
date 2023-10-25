package com.example.amishprofilepage.Views.Home;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.amishprofilepage.R;
import com.example.amishprofilepage.Views.Home.Adapter.UserAdapter;
import com.example.amishprofilepage.databinding.ActivityHomeBinding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding xml;
    private List<String> nameList;
    private int followingCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //root
        xml = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(xml.getRoot());

        //init
        followingCount = Integer.parseInt(xml.followingCount.getText().toString());
        nameList = Arrays.asList(
                "Emma", "Liam", "Olivia", "Noah", "Ava", "Isabella", "Sophia", "Jackson", "Aiden", "Lucas",
                "Oliver", "Caden", "Ethan", "Michael", "Elizabeth", "Mia", "Charlotte", "Abigail", "Camila", "Emily",
                "Grace", "Madison", "Avery", "Sofia", "Scarlett", "James", "Benjamin", "Henry", "Alexander", "Sebastian",
                "Elijah", "David", "William", "Joseph", "Matthew", "Samuel", "Daniel", "Jackson", "Logan", "Liam", "Mason",
                "John", "David", "James", "Oliver", "Joseph", "Michael", "Thomas", "William"
        );

        //vertical Recyclerview
        xml.profilesRecyclerView.setLayoutManager(
                new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        showProgressBar();
        setAdapter();
    }

    private void setAdapter(){
        if(nameList!=null){

            UserAdapter userAdapter = new UserAdapter(this, nameList, new UserAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(boolean bool) {
                    if(bool){
                        followingCount++;

                    }
                    else{
                        followingCount--;
                    }

                    //update following text count
                    xml.followingCount.setText(String.valueOf(followingCount));
                }
            });

            xml.profilesRecyclerView.setAdapter(userAdapter);
            hideProgressBar();
        }
    }

    private void showProgressBar(){
        xml.profilesRecyclerView.setVisibility(View.GONE);
        xml.progressbar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar(){
        xml.profilesRecyclerView.setVisibility(View.VISIBLE);
        xml.progressbar.setVisibility(View.GONE);
    }
}