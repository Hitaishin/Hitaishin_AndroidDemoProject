package com.citimate.fragment.chat;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.citimate.R;
import com.citimate.adapter.chat.MemberListAdapter;
import com.citimate.bean.chat.MemberListModel;

import java.util.ArrayList;

public class MemberFragment extends Fragment {

    private RecyclerView rvMember;
    private LinearLayoutManager layoutManager;
    private ArrayList<MemberListModel> memberListModels;
    private MemberListAdapter memberListAdapter;

    private String[] status = {"Lorem Ipsum is simply dummy text of the printing", "Ts is a long established fact that a reader will be...", "It look like readable English.", "Lorem Ipsum has been the industry's standard dummy text...", "Lorem Ipsum is not only simply random text.", "Lorem Ipsum is not only simply dummy text of printing.", "Lorem Ipsum is not only simply dummy text of printing.", "Lorem Ipsum is not only simply dummy text of printing."};
    private String[] time = {"Now", "30 min Ago", "1 hr Ago", "2:25 PM", "1:45 PM", "11:54 AM", "1:28 AM", "9:33 AM"};
    private String[] userName = {"Usher's Mack", "Citimate Team", "Ming Fang", "Liam Ng ", "Jessica Wong", "Noel Hansel", "Dave Scarf", "Mack jack"};
    private int[] userProfile = {R.drawable.balak, R.drawable.ic_image_usera, R.drawable.ic_image_userb, R.drawable.ic_image_userc, R.drawable.ic_image_userd, R.drawable.ic_image_usere, R.drawable.balak, R.drawable.ic_image_usera};

    public MemberFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_member, container, false);
        rvMember = (RecyclerView) v.findViewById(R.id.rvMember);
        initialization();
        return v;
    }

    //    Views Id Initialize Method
    public void initialization() {
        rvMember.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        rvMember.setLayoutManager(layoutManager);
        memberListModels = new ArrayList<>();

        setValues();
    }

    //    Static Data ArrayList Add Method
    private void setValues() {
        for (int i = 0; i < userName.length; i++) {
            MemberListModel listModel = new MemberListModel();
            listModel.setUserProfile(userProfile[i]);
            listModel.setUserName(userName[i]);
            listModel.setStatus(status[i]);
            listModel.setTime(time[i]);
            memberListModels.add(listModel);
        }
        memberListAdapter = new MemberListAdapter(getActivity(), memberListModels);
        rvMember.setAdapter(memberListAdapter);
    }
}
