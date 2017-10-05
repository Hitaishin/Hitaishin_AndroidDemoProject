package com.citimate.adapter.home;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.citimate.R;
import com.citimate.activity.DetailsActivity;
import com.citimate.bean.home.ListModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Locale;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    private ArrayList<ListModel> listModels;
    private Activity context;

    public static ArrayList<ListModel> arraylist = new ArrayList<ListModel>();

    public ListAdapter(Activity context, ArrayList<ListModel> listModels) {
        this.listModels = listModels;
        this.context = context;
        this.arraylist.clear();
        this.arraylist.addAll(this.listModels);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

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

        holder.ivListImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailsActivity.class);
                intent.putExtra("ItemName", listModels.get(position).getItemName());
                intent.putExtra("Distance", listModels.get(position).getDistance());
                intent.putExtra("Tags", listModels.get(position).getTags());
                intent.putExtra("Rating", listModels.get(position).getRating());
                intent.putExtra("Image", listModels.get(position).getItemImage());
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
        private TextView tvDistance, tvItemName, tvTags;
        private ImageView ivListImage;
        private RatingBar ratingBar;

        public ViewHolder(View view) {
            super(view);

            ivListImage = (ImageView) view.findViewById(R.id.ivListImage);
            tvItemName = (TextView) view.findViewById(R.id.tvItemName);
            tvDistance = (TextView) view.findViewById(R.id.tvDistance);
            tvTags = (TextView) view.findViewById(R.id.tvTags);
            ratingBar = (RatingBar) view.findViewById(R.id.ratingBar);
        }
    }

    // Filter Class
    public void filter(String charText, int textlength) {
        charText = charText.toLowerCase(Locale.getDefault());
        listModels.clear();
        if (charText.length() == 0) {
            listModels.addAll(arraylist);
        } else {

            for (ListModel friendsListModel : arraylist) {
                try {
                    //if (charText.equalsIgnoreCase((String) friendsListModel.get_clientFName().toLowerCase(Locale.getDefault()).subSequence(0, textlength))) {
                    String name = friendsListModel.getItemName().toLowerCase();
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
