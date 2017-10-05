package com.citimate.fragment.following;


import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.citimate.R;
import com.citimate.adapter.following.FollowingListAdapter;
import com.citimate.bean.following.FollowingListModel;

import java.util.ArrayList;
import java.util.Locale;

public class FollowingFragment extends Fragment {

    private EditText etSearch;
    private RecyclerView rvFollowing;
    private ArrayList<FollowingListModel> followingListModels;
    private FollowingListAdapter followingListAdapter;
    private ImageView ivRemoveSearch;

    private String[] name = {"Usher's Mack", "Mackle More", "Wacca Cool", "Selvin Waalke", "Munnue Jack", "Ming Fang"};
    private String[] followersCount = {"34 Follower",
            "9 Follower",
            "78 Follower",
            "45 Follower",
            "22 Follower",
            "49 Follower"};
    private String[] status = {"I am finding someone to drink...",
            "Going for party, can you come?",
            "Hey cool app for drinkers.",
            "We are waiting...",
            "I am finding someone to drink...",
            "I am finding someone to drink..."};
    private int[] userProfile = {R.drawable.ic_image_usere, R.drawable.ic_image_usera, R.drawable.ic_image_userd, R.drawable.ic_image_userc,
            R.drawable.ic_image_userb, R.drawable.balak};

    public FollowingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_saved_following, container, false);

        initialization(v);
        filter();
        return v;
    }


    public void initialization(View v) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getActivity().getWindow().setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.color_statusBar));
        }

//        RecyclerView Setup
        rvFollowing = (RecyclerView) v.findViewById(R.id.rvFollowing);
        rvFollowing.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvFollowing.setLayoutManager(layoutManager);
        followingListModels = new ArrayList<>();
        setValues();

//        EditText Setup
        etSearch = (EditText) v.findViewById(R.id.etSearch);

//        ImageView Setup
        ivRemoveSearch = (ImageView) v.findViewById(R.id.ivRemoveSearch);

        ivRemoveSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etSearch.setText("");
            }
        });
    }

    //    Filter Data Method
    private void filter() {
        etSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub

                try {
                    String text = etSearch.getText().toString().toLowerCase(Locale.getDefault());
                    int textlength = etSearch.getText().length();

                    followingListAdapter.filter(text, textlength);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
            }
        });
    }

    //    Static Data Set Method
    private void setValues() {
        for (int i = 0; i < name.length; i++) {
            FollowingListModel listModel = new FollowingListModel();
            listModel.setUserProfile(userProfile[i]);
            listModel.setName(name[i]);
            listModel.setFollowingCount(followersCount[i]);
            listModel.setStatus(status[i]);
            followingListModels.add(listModel);
        }
        followingListAdapter = new FollowingListAdapter(getActivity(), followingListModels);
        rvFollowing.setAdapter(followingListAdapter);
    }
}
