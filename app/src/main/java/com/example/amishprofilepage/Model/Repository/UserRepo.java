package com.example.amishprofilepage.Model.Repository;

import android.app.Application;

import com.example.amishprofilepage.Model.RoomDB.AppDatabase;
import com.example.amishprofilepage.Model.RoomDB.User;

import java.util.ArrayList;

public class UserRepo {

    private Application application;
    private AppDatabase appDatabase;

    public UserRepo(Application application) {
        this.application = application;
       appDatabase = AppDatabase.getDB(application.getApplicationContext());
    }


    public ArrayList<User> getAllUsers(){
        return (ArrayList<User>) appDatabase.userDao().getAllRecords();
    }

    public void updateUser(User user){
        appDatabase.userDao().updateRecord(user);
    }

    public int getFollowedUserCount(){
        return appDatabase.userDao().getFollowedUserCount();
    }
}
