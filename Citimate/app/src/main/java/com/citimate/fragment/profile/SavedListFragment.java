package com.citimate.fragment.profile;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.citimate.R;
import com.citimate.adapter.profile.SavedListAdapter;
import com.citimate.bean.profile.SavedListModel;

import java.util.ArrayList;

public class SavedListFragment extends Fragment {

    private RecyclerView rvSavedList;
    private ArrayList<SavedListModel> savedListModels;
    private SavedListAdapter savedListAdapter;
    private LinearLayoutManager mLayoutManager;

    private String[] name = {"Banglore Pub", "Sayaji", "Guru Kripa", "Mantis Restaurants", "Bear Bar", "Beer Gardom"};
    private String[] tags = {"Pub / Restaurants", "Sayaji / Restaurants", "Guru Kripa / Restaurants", "Mantis Restaurants", "Bar / Pubs", "Beer Gardom / Restaurants"};
    private String[] distance = {"1.2 Miles", "1.6 Miles", "1.7 Miles", "2.2 Miles", "3.2 Miles", "5.2 Miles"};
    private String[] rating = {"2", "3", "1", "4", "3", "1"};
    private int[] image = {R.drawable.ab, R.drawable.bc, R.drawable.cd, R.drawable.de,
            R.drawable.ef, R.drawable.fg};

    public SavedListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_saved_list, container, false);
        rvSavedList = (RecyclerView) v.findViewById(R.id.rvSavedList);
        initGridItemViews();
        return v;
    }

    private void initGridItemViews() {
        rvSavedList.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        rvSavedList.setLayoutManager(mLayoutManager);
        savedListModels = new ArrayList<>();
        setValues();
    }

    //    Static Data Set Method
    private void setValues() {
        for (int i = 0; i < name.length; i++) {
            SavedListModel listModel = new SavedListModel();
            listModel.setItemImage(image[i]);
            listModel.setItemName(name[i]);
            listModel.setDistance(distance[i]);
            listModel.setTags(tags[i]);
            listModel.setRating(rating[i]);
            savedListModels.add(listModel);
        }
        savedListAdapter = new SavedListAdapter(getActivity(), savedListModels);
        rvSavedList.setAdapter(savedListAdapter);
    }
}
