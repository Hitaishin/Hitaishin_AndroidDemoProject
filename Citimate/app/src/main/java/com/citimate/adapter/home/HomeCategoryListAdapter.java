package com.citimate.adapter.home;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.citimate.R;
import com.citimate.activity.ListActivity;
import com.citimate.bean.home.CategoryListModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class HomeCategoryListAdapter extends RecyclerView.Adapter<HomeCategoryListAdapter.ViewHolder> {

    private ArrayList<CategoryListModel> categoryListModels;
    private Activity context;

    public HomeCategoryListAdapter(Activity context, ArrayList<CategoryListModel> categoryListModels) {
        this.categoryListModels = categoryListModels;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_home_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.tvCategoryName.setText(categoryListModels.get(position).getBarName());

        Picasso.with(context)
                .load(categoryListModels.get(position).getBarImage())
                .centerCrop()
                .resize(150, 150)
                .into(holder.ivCategoryImage);

        holder.ivCategoryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ListActivity.class);
                context.startActivity(intent);
                context.overridePendingTransition(0, 0);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoryListModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvCategoryName;
        private ImageView ivCategoryImage;

        public ViewHolder(View view) {
            super(view);

            ivCategoryImage = (ImageView) view.findViewById(R.id.ivCategoryImage);
            tvCategoryName = (TextView) view.findViewById(R.id.tvCategoryName);

        }
    }
}
