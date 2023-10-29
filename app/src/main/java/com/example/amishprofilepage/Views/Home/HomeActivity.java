package com.example.amishprofilepage.Views.Home;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.amishprofilepage.Model.RoomDB.User;
import com.example.amishprofilepage.ViewModel.UserViewModel;
import com.example.amishprofilepage.Views.Home.Adapter.UserAdapter;
import com.example.amishprofilepage.databinding.ActivityHomeBinding;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private ActivityHomeBinding xml;
    private List<User> userList = new ArrayList<>();
    private int followingCount;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //root
        xml = ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(xml.getRoot());

        //init
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
        fetchData();

        //initializing the following text
        xml.followingCount.setText(String.valueOf(followingCount));

        //vertical Recyclerview
        xml.profilesRecyclerView.setLayoutManager(
                new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));

        showProgressBar();
        setAdapter();
    }

    private void setAdapter(){
        if(userList!=null){

            UserAdapter userAdapter = new UserAdapter(this, userList, new UserAdapter.OnItemClickListener() {
                @Override
                public void onItemClick(boolean bool, int position) {
                    if(bool){
                        followingCount++;
                        updateUser(position);
                    }
                    else{
                        followingCount--;
                        updateUser(position);
                    }

                    //update following text count
                    xml.followingCount.setText(String.valueOf(followingCount));
                }
            });

            xml.profilesRecyclerView.setAdapter(userAdapter);
            hideProgressBar();
        }
    }

    private void fetchData(){
        userList = userViewModel.getAllUsers();
        followingCount = userViewModel.getFollowedUserCount() + 100;
    }

    private void updateUser(int position){
        userViewModel.updateUser(userList.get(position));
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