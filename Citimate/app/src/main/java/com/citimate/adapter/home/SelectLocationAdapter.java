package com.citimate.adapter.home;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.citimate.R;
import com.citimate.bean.home.SelectLocationModel;

import java.util.ArrayList;

public class SelectLocationAdapter extends RecyclerView.Adapter<SelectLocationAdapter.ViewHolder> {

    private ArrayList<SelectLocationModel> listModels;
    private Activity context;

    public SelectLocationAdapter(Activity context, ArrayList<SelectLocationModel> listModels) {
        this.listModels = listModels;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_select_location_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.tvLocation.setText(listModels.get(position).getLocation());
    }

    @Override
    public int getItemCount() {
        return listModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvLocation;

        public ViewHolder(View view) {
            super(view);

            tvLocation = (TextView) view.findViewById(R.id.tvLocation);
        }
    }
}
