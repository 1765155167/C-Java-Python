package com.hqf.fragmenttest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NewsTitleFragment extends Fragment {
    private boolean isTwoPane;

    class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {
        private List<News> newsList;

        public NewsAdapter(List<News> newsList) {
            this.newsList = newsList;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.news_item, parent, false);
            final ViewHolder holder = new ViewHolder(view);
            holder.newsTitleText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    News news = newsList.get(holder.getAdapterPosition());
                    if (isTwoPane) {
                        NewsContentFragment newsContentFragment =
                                (NewsContentFragment) getFragmentManager()
                                .findFragmentById(R.id.news_cotent_fragment);
                        newsContentFragment.refresh(news.getTitle(), news.getContent());
                    } else {
                        NewsContentActivity.actionStart(getActivity(),
                                news.getTitle(), news.getContent());
                    }
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            News news = newsList.get(position);
            holder.newsTitleText.setText(news.getTitle());
        }

        @Override
        public int getItemCount() {
            return newsList.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView newsTitleText;
            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                newsTitleText = (TextView) itemView.findViewById(R.id.news_title);
            }
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.news_title_frag, container, false);
        RecyclerView newsTitleRecyclerView = (RecyclerView)
                view.findViewById(R.id.news_title_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        NewsAdapter adapter = new NewsAdapter(getNews());
        newsTitleRecyclerView.setLayoutManager(layoutManager);
        newsTitleRecyclerView.setAdapter(adapter);
        return view;
    }

    private List<News> getNews() {
        List<News> newsList = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            News news = new News();
            news.setTitle("This is news title" + i);
            news.setContent(getRandomLengthContent("This is news content"+ i + "."));
            newsList.add(news);
        }
        return newsList;
    }

    private String getRandomLengthContent(String s) {
        Random random = new Random();
        int length = random.nextInt(20)+1;
        StringBuilder builder = new StringBuilder();
        for (int i =0 ; i < length; i++) {
            builder.append(s);
        }
        return builder.toString();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (getActivity().findViewById(R.id.news_content_layout)!= null) {
            isTwoPane = true;
        } else {
            isTwoPane = false;
        }
    }
}
