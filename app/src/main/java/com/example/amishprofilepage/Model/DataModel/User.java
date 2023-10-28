package com.example.amishprofilepage.Model.DataModel;

public class User {

    String name;
    boolean isFollow;

    public User(String name) {
        this.name = name;
        isFollow = false;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFollow() {
        return isFollow;
    }

    public void setFollow(boolean follow) {
        isFollow = follow;
    }
}
