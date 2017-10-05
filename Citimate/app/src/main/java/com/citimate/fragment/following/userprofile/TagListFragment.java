package com.citimate.fragment.following.userprofile;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.citimate.R;
import com.citimate.adapter.following.FollowingUserTagListAdapter;
import com.citimate.bean.following.FollowingProfileTagListModel;

import java.util.ArrayList;

public class TagListFragment extends Fragment {

    private RecyclerView rvTagList;
    private ArrayList<FollowingProfileTagListModel> tagListModels;
    private FollowingUserTagListAdapter tagListAdapter;
    private LinearLayoutManager mLayoutManager;

    private String[] name = {"English Pub", "DJ Bar", "Night Bar", "Unlimited Brink", "Party", "Adult Bar-18+"};
    private String[] count = {"(3)", "(12)", "(9)", "(20)", "(31)", "(2)"};

    public TagListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_following_tag_list, container, false);
        rvTagList = (RecyclerView) v.findViewById(R.id.rvTagList);
        initFollowingTagViews();
        return v;
    }

    private void initFollowingTagViews() {
        rvTagList.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(getActivity());
        rvTagList.setLayoutManager(mLayoutManager);
        tagListModels = new ArrayList<>();
        setValues();
    }

    //    Static Data Set Method
    private void setValues() {
        for (int i = 0; i < name.length; i++) {
            FollowingProfileTagListModel listModel = new FollowingProfileTagListModel();
            listModel.setTagListName(name[i]);
            listModel.setCount(count[i]);
            tagListModels.add(listModel);
        }
        tagListAdapter = new FollowingUserTagListAdapter(getActivity(), tagListModels);
        rvTagList.setAdapter(tagListAdapter);
    }
}
