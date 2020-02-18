package com.recyclerview.android;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class MyAdapter extends RecyclerView.Adapter {
    public static final int VIEW1 = 1;
    public static final int VIEW2 = 2;
    public static final int TYPE_FOOTER = 3;//上拉加载
    ArrayList<String> arrayList;
    private Context context;
    private onItemClickListener listener;

    public MyAdapter(ArrayList<String> arrayList) {
        if (arrayList.size() % 2  != 0) {
            this.arrayList = arrayList;
            this.arrayList.add("end");
        }
        this.arrayList = arrayList;
    }

    public void addNewItem() {
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        arrayList.add(1, "new Item");
        notifyItemInserted(1);
    }

    public void deleteItem() {
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        arrayList.remove(1);
        notifyItemRemoved(1);
    }

    public void updateData(ArrayList<String> data) {
        this.arrayList = data;
        notifyDataSetChanged();
    }

    public void setOnClickListener(onItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (context == null) {
            context = parent.getContext();
        }
        if (viewType == VIEW1) {
            View view = LayoutInflater.from(parent.getContext()).
                    inflate(R.layout.text_item, parent, false);
            return new ViewHolder(view);
        } else if (viewType == TYPE_FOOTER) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_item_foot, parent, false);
            return new FootViewHolder(view);
        }
        View view = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.text_item_two, parent, false);
        return new ViewHolder2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (getItemViewType(position) == VIEW1) {
            final ViewHolder viewHolder = (ViewHolder) holder;
            viewHolder.textView.setText("VIEW1");
            viewHolder.textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(viewHolder.textView);
                }
            });
        } else if (getItemViewType(position) == VIEW2) {
            final ViewHolder2 viewHolder2 = (ViewHolder2) holder;
            viewHolder2.textView1.setText(arrayList.get((position - 1) * 2));
            viewHolder2.textView2.setText(arrayList.get((position - 1) * 2 + 1));
            if (listener != null) {
                viewHolder2.textView1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.onClick(viewHolder2.textView1);
                    }
                });
                viewHolder2.textView2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        listener.onClick(viewHolder2.textView2);
                    }
                });
            }
        } else if (getItemViewType(position) == TYPE_FOOTER) {

        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size() / 2 + 2;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0) {
            return VIEW1;
        } else if (position == arrayList.size() / 2 + 1) {
            return TYPE_FOOTER;
        } else {
            return VIEW2;
        }
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.text_view);
        }
    }

    private class ViewHolder2 extends RecyclerView.ViewHolder {
        private TextView textView1;
        private TextView textView2;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);
            textView1 = itemView.findViewById(R.id.text_view1);
            textView2 = itemView.findViewById(R.id.text_view2);
        }
    }

    private class FootViewHolder extends RecyclerView.ViewHolder {
        private ContentLoadingProgressBar progressBar;

        public FootViewHolder(View itemView) {
            super(itemView);
            progressBar = itemView.findViewById(R.id.pb_progress);
        }
    }

    public interface onItemClickListener {
        void onClick(View view);
    }
}
