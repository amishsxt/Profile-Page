package com.example.amishprofilepage.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.amishprofilepage.Model.Repository.UserRepo;
import com.example.amishprofilepage.Model.RoomDB.User;

import java.util.ArrayList;

public class UserViewModel extends AndroidViewModel {

    private UserRepo userRepo;

    public UserViewModel(@NonNull Application application) {
        super(application);
        userRepo = new UserRepo(application);
    }

    public ArrayList<User> getAllUsers(){
        return userRepo.getAllUsers();
    }

    public void updateUser(User user){
        userRepo.updateUser(user);
    }

    public int getFollowedUserCount(){
        return userRepo.getFollowedUserCount();
    }
}
