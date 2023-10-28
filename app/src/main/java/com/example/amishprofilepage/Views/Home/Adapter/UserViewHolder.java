package com.example.amishprofilepage.Views.Home.Adapter;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amishprofilepage.R;

public class UserViewHolder extends RecyclerView.ViewHolder {

    TextView userName;
    Button followButton;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);

        userName = itemView.findViewById(R.id.userName);
        followButton = itemView.findViewById(R.id.followButton);
    }

    public void follow(){
        followButton.setText("Following");
    }

    public void unfollow(){
        followButton.setText("Follow");
    }
}
