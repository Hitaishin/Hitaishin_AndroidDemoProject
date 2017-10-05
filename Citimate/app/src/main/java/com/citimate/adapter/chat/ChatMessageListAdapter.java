package com.citimate.adapter.chat;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.citimate.R;
import com.citimate.bean.chat.ChatMessagesListModel;

import java.util.ArrayList;

public class ChatMessageListAdapter extends RecyclerView.Adapter<ChatMessageListAdapter.ViewHolder> {

    private ArrayList<ChatMessagesListModel> listModels;
    private Activity context;

    public ChatMessageListAdapter(Activity context, ArrayList<ChatMessagesListModel> listModels) {
        this.listModels = listModels;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_chat_messages, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        if (listModels.get(position).getType().equalsIgnoreCase("sender")) {

            holder.my_mssg_tv.setVisibility(View.VISIBLE);
            holder.my_time_tv.setVisibility(View.VISIBLE);

            holder.mssg_tv.setVisibility(View.GONE);
            holder.time_tv.setVisibility(View.GONE);

            holder.my_mssg_tv.setText(listModels.get(position).getMessage());
            holder.my_time_tv.setText(listModels.get(position).getTime());

        } else {
            holder.my_mssg_tv.setVisibility(View.GONE);
            holder.my_time_tv.setVisibility(View.GONE);

            holder.mssg_tv.setVisibility(View.VISIBLE);
            holder.time_tv.setVisibility(View.VISIBLE);

            holder.mssg_tv.setText(listModels.get(position).getMessage());
            holder.time_tv.setText(listModels.get(position).getTime());
        }
    }

    @Override
    public int getItemCount() {
        return listModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        //Receiver
        private TextView mssg_tv, time_tv;

        //Sender
        private TextView my_mssg_tv, my_time_tv;

        public ViewHolder(View view) {
            super(view);

            mssg_tv = (TextView) view.findViewById(R.id.mssg_tv);
            time_tv = (TextView) view.findViewById(R.id.time_tv);
            my_mssg_tv = (TextView) view.findViewById(R.id.my_mssg_tv);
            my_time_tv = (TextView) view.findViewById(R.id.my_time_tv);
        }
    }
}

