package com.example.amishprofilepage.Views.Home.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amishprofilepage.R;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    private Context context;
    private List<String> nameList;
    private OnItemClickListener clickListener;

    public UserAdapter(Context context, List<String> nameList, OnItemClickListener clickListener) {
        this.context = context;
        this.nameList = nameList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new UserViewHolder(LayoutInflater.from(context).inflate(R.layout.user_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.userName.setText(nameList.get(position));

        holder.followButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(holder.followState){
                    holder.unfollow();
                    clickListener.onItemClick(false);
                }
                else{
                    holder.follow();
                    clickListener.onItemClick(true);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(boolean bool);
    }
}
