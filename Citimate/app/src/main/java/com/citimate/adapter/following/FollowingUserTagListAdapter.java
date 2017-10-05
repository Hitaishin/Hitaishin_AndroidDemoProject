package com.citimate.adapter.following;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.citimate.R;
import com.citimate.activity.TagViewDetailsActivity;
import com.citimate.bean.following.FollowingProfileTagListModel;

import java.util.ArrayList;

public class FollowingUserTagListAdapter extends RecyclerView.Adapter<FollowingUserTagListAdapter.ViewHolder> {
    private ArrayList<FollowingProfileTagListModel> listModels;
    private Activity context;

    public FollowingUserTagListAdapter(Activity context, ArrayList<FollowingProfileTagListModel> listModels) {
        this.listModels = listModels;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_following_user_tag_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.tvTagList.setText(listModels.get(position).getTagListName() + listModels.get(position).getCount());

        holder.ivDeleteTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "In progress", Toast.LENGTH_SHORT).show();
            }
        });

        holder.ivNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "In progress", Toast.LENGTH_SHORT).show();
            }
        });

        holder.layoutMid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, TagViewDetailsActivity.class);
                intent.putExtra("name", listModels.get(position).getTagListName());
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
        private TextView tvTagList;
        private ImageView ivDeleteTag, ivNext;
        private RelativeLayout layoutMid;

        public ViewHolder(View view) {
            super(view);

            layoutMid = (RelativeLayout) view.findViewById(R.id.layoutMid);
            ivDeleteTag = (ImageView) view.findViewById(R.id.ivDeleteTag);
            ivNext = (ImageView) view.findViewById(R.id.ivNext);
            tvTagList = (TextView) view.findViewById(R.id.tvTagList);
        }
    }
}
