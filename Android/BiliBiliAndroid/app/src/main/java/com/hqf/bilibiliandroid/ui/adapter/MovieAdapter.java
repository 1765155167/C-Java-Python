package com.hqf.bilibiliandroid.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.hqf.bilibiliandroid.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class MovieAdapter extends RecyclerView.Adapter {
    public static final int MOVIE_ITEM = 1;
    public static final int MOVIE_HEAD = 2;
    public static final int MOVIE_FOOTER = 3;
    private static final String TAG = "MovieAdapter";
    private List<Movie> movieList;
    private Context context = null;
    private onItemClick itemClick;

    public void setItemClick(onItemClick itemClick) {
        this.itemClick = itemClick;
    }

    public MovieAdapter(List<Movie> movieList) {
        if (movieList.size() % 2 != 0) {
            movieList.add(new Movie("Apple", R.mipmap.apple));
        }
        this.movieList = movieList;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return MOVIE_HEAD;
        } else if (position == movieList.size() / 2 + 1) {
            return MOVIE_FOOTER;
        } else {
            return MOVIE_ITEM;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (context == null) {
            context = parent.getContext();
        }
        if (viewType == MOVIE_HEAD) {
            Log.d(TAG, "onCreateViewHolder: MOVIE_HEAD");
            View view = LayoutInflater.from(context).inflate(R.layout.recommend_head_item, parent, false);
            return new HeadViewHolder(view);
        } else if (viewType == MOVIE_FOOTER) {
            Log.d(TAG, "onCreateViewHolder: MOVIE_FOOTER");
            View view = LayoutInflater.from(context).inflate(R.layout.movie_foot, parent, false);
            return new FootViewHolder(view);
        } else {
//            Log.d(TAG, "onCreateViewHolder: MOVIE_ITEM");
            View view = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false);
            return new ViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if (getItemViewType(position) == MOVIE_HEAD) {
            HeadViewHolder headViewHolder = (HeadViewHolder) holder;
            if (itemClick != null) {
                headViewHolder.movieImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        itemClick.onClick(v, position);
                    }
                });
            }
        } else if (getItemViewType(position) == MOVIE_ITEM) {
            ViewHolder viewHolder = (ViewHolder) holder;
            Movie movie1 = movieList.get((position - 1) * 2);
            Movie movie2 = movieList.get((position - 1) * 2 + 1);
            viewHolder.movieName1.setText(movie1.getName());
            Glide.with(context).load(movie1.getImageId()).into(viewHolder.movieImage1);
            viewHolder.movieName2.setText(movie2.getName());
            Glide.with(context).load(movie2.getImageId()).into(viewHolder.movieImage2);
            if (itemClick != null) {
                viewHolder.movieImage1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        itemClick.onClick(v, (position - 1) * 2);
                    }
                });
                viewHolder.movieImage2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        itemClick.onClick(v, (position - 1) * 2 + 1);
                    }
                });
            }
        } else if (getItemViewType(position) == MOVIE_FOOTER) {

        }
    }

    @Override
    public int getItemCount() {
        return movieList.size() / 2 + 2;
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        ImageView movieImage1;
        ImageView movieImage2;
        TextView movieName1;
        TextView movieName2;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImage1 = itemView.findViewById(R.id.movie_image1);
            movieName1 = itemView.findViewById(R.id.movie_name1);
            movieImage2 = itemView.findViewById(R.id.movie_image2);
            movieName2 = itemView.findViewById(R.id.movie_name2);
        }
    }

    private class HeadViewHolder extends RecyclerView.ViewHolder {
        ImageView movieImage;
        TextView movieName;

        public HeadViewHolder(@NonNull View itemView) {
            super(itemView);
            movieImage = itemView.findViewById(R.id.movie_image);
            movieName = itemView.findViewById(R.id.movie_name);
        }
    }

    private class FootViewHolder extends RecyclerView.ViewHolder {
        private ContentLoadingProgressBar progressBar;

        public FootViewHolder(View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.pb_progress);
        }
    }

    public interface onItemClick {
        void onClick(View view, int position);
    }
}
