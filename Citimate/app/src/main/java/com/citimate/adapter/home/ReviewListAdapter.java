package com.citimate.adapter.home;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.citimate.CircleTransform;
import com.citimate.R;
import com.citimate.bean.home.ReviewListModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ReviewListAdapter extends RecyclerView.Adapter<ReviewListAdapter.ViewHolder> {

    private ArrayList<ReviewListModel> listModels;
    private Activity context;

    public ReviewListAdapter(Activity context, ArrayList<ReviewListModel> listModels) {
        this.listModels = listModels;
        this.context = context;
    }

    @Override
    public ReviewListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_reviews, parent, false);

        return new ReviewListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ReviewListAdapter.ViewHolder holder, final int position) {

        holder.tvDescription.setText(listModels.get(position).getDescription());
        holder.tvDay.setText(listModels.get(position).getTime());
        holder.tvUserName.setText(listModels.get(position).getUserName());

        float f = Float.parseFloat(listModels.get(position).getRating());
        holder.ratingBar.setRating(f);

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
        private TextView tvDescription, tvDay, tvUserName;
        private ImageView ivUserProfile;
        private LinearLayout linearLayout;
        private RatingBar ratingBar;

        public ViewHolder(View view) {
            super(view);

            ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
            linearLayout = (LinearLayout) view.findViewById(R.id.linearLayout);
            ivUserProfile = (ImageView) view.findViewById(R.id.ivUserProfile);
            tvDescription = (TextView) view.findViewById(R.id.tvDescription);
            tvDay = (TextView) view.findViewById(R.id.tvDay);
            tvUserName = (TextView) view.findViewById(R.id.tvUserName);

        }
    }
}

