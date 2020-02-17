package com.hqf.materialtest.friends;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hqf.materialtest.R;

import java.util.List;

public class FriendsAdapter extends RecyclerView.Adapter<FriendsAdapter.HolderView> {

    List<Friend> friends;
    Context context;

    public FriendsAdapter(Context context ,List<Friend> friends) {
        this.friends = friends;
        this.context = context;
    }

    @NonNull
    @Override
    public HolderView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.friend_item, parent,false);
        final HolderView holderView = new HolderView(view);
        holderView.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holderView.getAdapterPosition();
                Friend friend = friends.get(position);
                Toast.makeText(context, "click " + friend.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return holderView;
    }

    @Override
    public void onBindViewHolder(@NonNull HolderView holder, int position) {
        Friend friend = friends.get(position);
        holder.friendName.setText(friend.getName());
        holder.friendNumber.setText(friend.getNumber());
    }


    @Override
    public int getItemCount() {
        return friends.size();
    }

    class HolderView extends RecyclerView.ViewHolder {
        View itemView;
        ImageView friendImage;
        TextView friendName;
        TextView friendNumber;
        public HolderView(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            friendImage = itemView.findViewById(R.id.friend_image);
            friendNumber = itemView.findViewById(R.id.friend_number);
            friendName = itemView.findViewById(R.id.friend_name);
        }
    }
}
