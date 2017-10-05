package com.citimate.adapter.saved;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.citimate.CircleTransform;
import com.citimate.R;
import com.citimate.bean.saved.AddPlaceListModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Locale;

public class AddPlaceListAdapter extends RecyclerView.Adapter<AddPlaceListAdapter.ViewHolder> {

    private ArrayList<AddPlaceListModel> listModels;
    private Activity context;

    public static ArrayList<AddPlaceListModel> arrayList = new ArrayList<AddPlaceListModel>();

    public AddPlaceListAdapter(Activity context, ArrayList<AddPlaceListModel> listModels) {
        this.listModels = listModels;
        this.context = context;
        this.arrayList.clear();
        this.arrayList.addAll(this.listModels);
    }

    @Override
    public AddPlaceListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_add_place, parent, false);
        return new AddPlaceListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AddPlaceListAdapter.ViewHolder holder, final int position) {

        holder.tvAddress.setText(listModels.get(position).getAddress());
        holder.tvName.setText(listModels.get(position).getName());

        Picasso.with(context)
                .load(listModels.get(position).getUserProfile())
                .centerCrop()
                .resize(100, 100)
                .transform(new CircleTransform())
                .transform(new CircleTransform())
                .into(holder.ivUserProfile);
    }

    @Override
    public int getItemCount() {
        return listModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvAddress, tvName;
        private ImageView ivUserProfile;

        public ViewHolder(View view) {
            super(view);

//            ImageView Id
            ivUserProfile = (ImageView) view.findViewById(R.id.ivUserProfile);

//            TextView Id
            tvAddress = (TextView) view.findViewById(R.id.tvAddress);
            tvName = (TextView) view.findViewById(R.id.tvName);
        }
    }

    // Filter Class
    public void filter(String charText, int textlength) {
        charText = charText.toLowerCase(Locale.getDefault());
        listModels.clear();
        if (charText.length() == 0) {
            listModels.addAll(arrayList);
        } else {

            for (AddPlaceListModel friendsListModel : arrayList) {
                try {
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

