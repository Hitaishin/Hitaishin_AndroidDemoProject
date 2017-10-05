package com.citimate.adapter.following;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.citimate.R;
import com.citimate.bean.following.FollowingTagListModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FollowingTagListAdapter extends RecyclerView.Adapter<FollowingTagListAdapter.ViewHolder> {

    private ArrayList<FollowingTagListModel> listModels;
    private Activity context;

    public FollowingTagListAdapter(Activity context, ArrayList<FollowingTagListModel> listModels) {
        this.listModels = listModels;
        this.context = context;
    }

    @Override
    public FollowingTagListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_tag_list, parent, false);

        return new FollowingTagListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FollowingTagListAdapter.ViewHolder holder, final int position) {

        holder.tvItemName.setText(listModels.get(position).getItemName());
        holder.tvTags.setText(listModels.get(position).getTags());
        holder.tvPlaces.setText(listModels.get(position).getPlace());
        holder.tvUserName.setText(listModels.get(position).getUserName());

        Picasso.with(context)
                .load(listModels.get(position).getItemImage())
                .centerCrop()
                .resize(700, 700)
                .into(holder.ivListImage);

        Picasso.with(context)
                .load(listModels.get(position).getUserProfile())
                .centerCrop()
                .resize(100, 100)
                .into(holder.ivUserProfile);
    }

    @Override
    public int getItemCount() {
        return listModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvPlaces, tvItemName, tvTags, tvUserName;
        private ImageView ivListImage, ivUserProfile;
        private LinearLayout linearLayout;

        public ViewHolder(View view) {
            super(view);

            linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);
            ivUserProfile = (ImageView) view.findViewById(R.id.ivUserProfile);
            ivListImage = (ImageView) view.findViewById(R.id.ivListImage);
            tvItemName = (TextView) view.findViewById(R.id.tvItemName);
            tvPlaces = (TextView) view.findViewById(R.id.tvPlaces);
            tvTags = (TextView) view.findViewById(R.id.tvTags);
            tvUserName = (TextView) view.findViewById(R.id.tvUserName);
        }
    }
}

