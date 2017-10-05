package com.citimate.adapter.saved;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.citimate.R;
import com.citimate.bean.saved.TagViewDetailsModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TagViewDetailsAdapter extends RecyclerView.Adapter<TagViewDetailsAdapter.ViewHolder> {

    private ArrayList<TagViewDetailsModel> listModels;
    private Activity context;

    public TagViewDetailsAdapter(Activity context, ArrayList<TagViewDetailsModel> listModels) {
        this.listModels = listModels;
        this.context = context;

    }

    @Override
    public TagViewDetailsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_save_saved_list, parent, false);

        return new TagViewDetailsAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TagViewDetailsAdapter.ViewHolder holder, final int position) {

        holder.tvItemName.setText(listModels.get(position).getItemName());
        holder.tvDistance.setText(listModels.get(position).getDistance());
        holder.tvTags.setText(listModels.get(position).getTags());

        float f = Float.parseFloat(listModels.get(position).getRating());
        holder.ratingBar.setRating(f);

        Picasso.with(context)
                .load(listModels.get(position).getItemImage())
                .centerCrop()
                .resize(700, 700)
                .into(holder.ivListImage);

        holder.tvAddTag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "In progress", Toast.LENGTH_SHORT).show();
            }
        });

        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "In progress", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvDistance, tvItemName, tvTags, tvAddTag, text1;
        private ImageView ivListImage, ivDelete;
        private RatingBar ratingBar;

        public ViewHolder(View view) {
            super(view);

            ivDelete = (ImageView) view.findViewById(R.id.ivDelete);
            ivListImage = (ImageView) view.findViewById(R.id.ivListImage);
            tvItemName = (TextView) view.findViewById(R.id.tvItemName);
            tvDistance = (TextView) view.findViewById(R.id.tvDistance);
            tvTags = (TextView) view.findViewById(R.id.tvTags);
            tvAddTag = (TextView) view.findViewById(R.id.tvAddTag);
            text1 = (TextView) view.findViewById(R.id.text1);
            ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);

        }
    }
}

