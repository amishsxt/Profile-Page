package com.example.amishprofilepage.Views.Home.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amishprofilepage.Model.DataModel.User;
import com.example.amishprofilepage.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private Context context;
    private List<User> userList;
    private OnItemClickListener clickListener;

    public UserAdapter(Context context, List<User> userList, OnItemClickListener clickListener) {
        this.context = context;
        this.userList = userList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(context).inflate(R.layout.user_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        //init views data
        holder.userName.setText(userList.get(position).getName());
        holder.followButton.setText(userList.get(position).isFollow() ? "Following" : "Follow");

        holder.followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!userList.get(position).isFollow()){
                    holder.follow();
                    userList.get(position).setFollow(true);
                    clickListener.onItemClick(true);
                }
                else{
                    holder.unfollow();
                    userList.get(position).setFollow(false);
                    clickListener.onItemClick(false);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(boolean bool);
    }
}
