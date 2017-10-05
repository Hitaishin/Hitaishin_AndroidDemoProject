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
import com.citimate.bean.chat.MemberListModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MemberListAdapter extends RecyclerView.Adapter<MemberListAdapter.ViewHolder> {

    private ArrayList<MemberListModel> listModels;
    private Activity context;

    public MemberListAdapter(Activity context, ArrayList<MemberListModel> listModels) {
        this.listModels = listModels;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_chat_member, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.tvStatus.setText(listModels.get(position).getStatus());
        holder.tvDay.setText(listModels.get(position).getTime());
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
            tvStatus = (TextView) view.findViewById(R.id.tvStatus);
            tvDay = (TextView) view.findViewById(R.id.tvDay);
            tvUserName = (TextView) view.findViewById(R.id.tvUserName);

        }
    }
}

