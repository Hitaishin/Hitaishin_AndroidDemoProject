package com.citimate.adapter.home;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.citimate.CircleTransform;
import com.citimate.R;
import com.citimate.bean.home.ScoopListModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ScoopListAdapter extends RecyclerView.Adapter<ScoopListAdapter.ViewHolder> {

    private ArrayList<ScoopListModel> listModels;
    private Activity context;

    public ScoopListAdapter(Activity context, ArrayList<ScoopListModel> listModels) {
        this.listModels = listModels;
        this.context = context;

    }

    @Override
    public ScoopListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_scoop, parent, false);

        return new ScoopListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ScoopListAdapter.ViewHolder holder, final int position) {

        holder.tvComment.setText(listModels.get(position).getComment());
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
        private TextView tvComment, tvDay, tvUserName;
        private ImageView ivUserProfile;

        public ViewHolder(View view) {
            super(view);

            ivUserProfile = (ImageView) view.findViewById(R.id.ivUserProfile);
            tvComment = (TextView) view.findViewById(R.id.tvComment);
            tvDay = (TextView) view.findViewById(R.id.tvDay);
            tvUserName = (TextView) view.findViewById(R.id.tvUserName);

        }
    }
}

