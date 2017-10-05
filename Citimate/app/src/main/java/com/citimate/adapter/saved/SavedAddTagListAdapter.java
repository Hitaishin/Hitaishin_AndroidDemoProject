package com.citimate.adapter.saved;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.citimate.R;
import com.citimate.bean.saved.SavedAddTagListModel;

import java.util.ArrayList;

public class SavedAddTagListAdapter extends RecyclerView.Adapter<SavedAddTagListAdapter.ViewHolder> {

    private ArrayList<SavedAddTagListModel> listModels;
    private Activity context;

    public SavedAddTagListAdapter(Activity context, ArrayList<SavedAddTagListModel> listModels) {
        this.listModels = listModels;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_saved_add_tag_list, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        holder.tvTagList.setText(listModels.get(position).getTagListName());

        holder.layoutMid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listModels.get(position).isChecked()) {
                    holder.tvTagList.setTextColor(Color.parseColor("#adadad"));
                    holder.ivClickDone.setVisibility(View.GONE);

                } else {
                    holder.tvTagList.setTextColor(Color.parseColor("#00BFFE"));
                    holder.ivClickDone.setVisibility(View.VISIBLE);
                }
                listModels.get(position).setChecked(!listModels.get(position).isChecked());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTagList;
        private ImageView ivClickDone;
        private RelativeLayout layoutMid;

        public ViewHolder(View view) {
            super(view);

            layoutMid = (RelativeLayout) view.findViewById(R.id.layoutMid);
            ivClickDone = (ImageView) view.findViewById(R.id.ivClickDone);
            tvTagList = (TextView) view.findViewById(R.id.tvTagList);

        }
    }
}
