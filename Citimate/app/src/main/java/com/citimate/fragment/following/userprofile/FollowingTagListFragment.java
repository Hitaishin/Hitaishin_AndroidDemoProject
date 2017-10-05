package com.citimate.fragment.following.userprofile;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.citimate.R;
import com.citimate.adapter.following.FollowingTagListAdapter;
import com.citimate.bean.following.FollowingTagListModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FollowingTagListFragment extends Fragment {

    private RecyclerView rvTagList;
    private ArrayList<FollowingTagListModel> tagListModels;
    private FollowingTagListAdapter tagListAdapter;
    private LinearLayoutManager mLayoutManager;

    private String[] name = {"Banglore Pub", "Sayaji", "Guru Kripa", "Mantis Restaurants", "Bear Bar", "Beer Gardom"};
    private String[] tags = {"Pub / Restaurants", "Sayaji / Restaurants", "Guru Kripa / Restaurants", "Mantis Restaurants", "Bar / Pubs", "Beer Gardom / Restaurants"};
    private String[] place = {"1", "5", "6", "2", "3", "5"};
    private String[] userName = {"Robot", "Wacca Cool", "Mannue Jack", "Devid Thomes ", "Mackle More", "Usher's Mack"};
    private int[] image = {R.drawable.ab, R.drawable.bc, R.drawable.cd, R.drawable.de,
            R.drawable.ef, R.drawable.fg};
    private int[] userProfile = {R.drawable.balak, R.drawable.ic_image_usera, R.drawable.ic_image_userb, R.drawable.ic_image_userc,
            R.drawable.ic_image_userd, R.drawable.ic_image_usere};

    public FollowingTagListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tag_list, container, false);
        initGridItemViews(v);
        return v;
    }

    private void initGridItemViews(View v) {
        rvTagList = (RecyclerView) v.findViewById(R.id.rvTagList);
        rvTagList.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        rvTagList.setLayoutManager(mLayoutManager);
        tagListModels = new ArrayList<>();
        setValues();
    }

    //    Static Data Set Method
    private void setValues() {
        for (int i = 0; i < name.length; i++) {
            FollowingTagListModel listModel = new FollowingTagListModel();
            listModel.setItemImage(image[i]);
            listModel.setItemName(name[i]);
            listModel.setPlace(place[i]);
            listModel.setTags(tags[i]);
            listModel.setUserName(userName[i]);
            listModel.setUserProfile(userProfile[i]);
            tagListModels.add(listModel);
        }
        tagListAdapter = new FollowingTagListAdapter(getActivity(), tagListModels);
        rvTagList.setAdapter(tagListAdapter);
    }
}
