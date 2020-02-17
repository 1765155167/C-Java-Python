package com.hqf.recyclerview;

import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FruitsAdapter extends RecyclerView.Adapter<FruitsAdapter.ViewHolder> {

    private List<Fruit> fruitList;

    public FruitsAdapter(List<Fruit> fruitList) {
        this.fruitList = fruitList;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView;
        View itemView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.image_view);
            textView = (TextView) itemView.findViewById(R.id.text_view);
            this.itemView = itemView;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, final int viewType) {
        View  view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,
                parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Fruit fruit = fruitList.get(position);
                Toast.makeText(view.getContext(), "you click Image " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Fruit fruit = fruitList.get(position);
        holder.textView.setText(fruit.getName());
        holder.imageView.setImageResource(fruit.getImageId());
    }

    @Override
    public int getItemCount() {
        return fruitList.size();
    }
}
