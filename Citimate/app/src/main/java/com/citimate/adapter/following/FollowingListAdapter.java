package com.citimate.adapter.following;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.citimate.CircleTransform;
import com.citimate.R;
import com.citimate.activity.FollowingUserProfileActivity;
import com.citimate.bean.following.FollowingListModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Locale;

public class FollowingListAdapter extends RecyclerView.Adapter<FollowingListAdapter.ViewHolder> {

    private ArrayList<FollowingListModel> listModels;
    private Activity context;
    public static ArrayList<FollowingListModel> arraylist = new ArrayList<FollowingListModel>();

    public FollowingListAdapter(Activity context, ArrayList<FollowingListModel> listModels) {
        this.listModels = listModels;
        this.context = context;
        this.arraylist.clear();
        this.arraylist.addAll(this.listModels);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_saved_following_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.tvFollowersNumbers.setText(listModels.get(position).getFollowingCount());
        holder.tvName.setText(listModels.get(position).getName());
        holder.tvStatus.setText(listModels.get(position).getStatus());

        Picasso.with(context)
                .load(listModels.get(position).getUserProfile())
                .centerCrop()
                .resize(100, 100)
                .transform(new CircleTransform())
                .into(holder.ivUserProfile);

        holder.tvFollowing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "In progress", Toast.LENGTH_SHORT).show();
            }
        });

        holder.ivUserProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context, FollowingUserProfileActivity.class);
                context.startActivity(intent);
                context.overridePendingTransition(0, 0);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvFollowersNumbers, tvName, tvStatus, tvFollowing;
        private ImageView ivUserProfile;

        public ViewHolder(View view) {
            super(view);

            ivUserProfile = (ImageView) view.findViewById(R.id.ivUserProfile);
            tvFollowersNumbers = (TextView) view.findViewById(R.id.tvFollowersNumbers);
            tvName = (TextView) view.findViewById(R.id.tvName);
            tvStatus = (TextView) view.findViewById(R.id.tvStatus);
            tvFollowing = (TextView) view.findViewById(R.id.tvFollowing);
        }
    }

    // Filter Class
    public void filter(String charText, int textlength) {
        charText = charText.toLowerCase(Locale.getDefault());
        listModels.clear();
        if (charText.length() == 0) {
            listModels.addAll(arraylist);
        } else {

            for (FollowingListModel friendsListModel : arraylist) {
                try {
                    //if (charText.equalsIgnoreCase((String) friendsListModel.get_clientFName().toLowerCase(Locale.getDefault()).subSequence(0, textlength))) {
                    String name = friendsListModel.getName().toLowerCase();
                    name = name.trim();

                    if (name.contains(charText.toString().toLowerCase())) {
                        //if (wp.getCountry().toLowerCase(Locale.getDefault()).contains(charText)) {
                        listModels.add(friendsListModel);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        notifyDataSetChanged();
    }
}

