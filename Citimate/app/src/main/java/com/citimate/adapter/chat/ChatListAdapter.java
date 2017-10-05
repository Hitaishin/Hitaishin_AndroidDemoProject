package com.citimate.adapter.chat;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.citimate.CircleTransform;
import com.citimate.R;
import com.citimate.bean.chat.ChatListModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListAdapter.ViewHolder> {

    private ArrayList<ChatListModel> listModels;
    private Activity context;

    public ChatListAdapter(Activity context, ArrayList<ChatListModel> listModels) {
        this.listModels = listModels;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_chat_chatlist, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.tvUserName.setText(listModels.get(position).getUserName());

        Picasso.with(context)
                .load(listModels.get(position).getUserProfile())
                .centerCrop()
                .resize(100, 100)
                .transform(new CircleTransform())
                .into(holder.ivUserProfile);
    }

    @Override
    public int getItemCount() {
        return listModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvStatus, tvDay, tvUserName;
        private ImageView ivUserProfile;

        public ViewHolder(View view) {
            super(view);

            ivUserProfile = (ImageView) view.findViewById(R.id.ivUserProfile);
            tvUserName = (TextView) view.findViewById(R.id.tvUserName);

        }
    }
}

