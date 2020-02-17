package com.hqf.uibestpractice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MsgAdapterNew extends RecyclerView.Adapter<MsgAdapterNew.ViewHolder> {

    private List<Msg> msgList;

    public MsgAdapterNew(List<Msg> msgList) {
        this.msgList = msgList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.msg_item_new, parent, false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.rightMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(parent.getContext(), viewHolder.rightMsg.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.leftMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(parent.getContext(), viewHolder.leftMsg.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Msg msg = msgList.get(position);
        if (msg.getType() == Msg.TYPE_RECEIVED) {
            //显示左边消息，右边隐藏
            holder.leftMsg.setVisibility(View.VISIBLE);
            holder.rightMsg.setVisibility(View.GONE);
            holder.leftMsg.setText(msg.getContent());
        } else if (msg.getType() == Msg.TYPE_SENT) {
            //显示右边，左边隐藏
            holder.rightMsg.setVisibility(View.VISIBLE);
            holder.leftMsg.setVisibility(View.GONE);
            holder.rightMsg.setText(msg.getContent());
        }
    }

    @Override
    public int getItemCount() {
        return msgList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView leftMsg;
        TextView rightMsg;
        View itemView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            leftMsg = (TextView) itemView.findViewById(R.id.textView3);
            rightMsg = (TextView) itemView.findViewById(R.id.textView4);
        }
    }
}
