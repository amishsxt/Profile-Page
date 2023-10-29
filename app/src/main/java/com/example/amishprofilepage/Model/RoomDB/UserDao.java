package com.example.amishprofilepage.Model.RoomDB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {

    @Query("select *from User order by id desc")
    List<User> getAllRecords();

    @Insert
    void insertRecord(User user);

    @Delete
    void deleteRecord(User user);

    @Update
    void updateRecord(User user);

    @Query("select count(*) from User")
    int getRecordCount();

    @Query("select count(*) from User where isFollow = 1")
    int getFollowedUserCount();
}
