package com.citimate.fragment.chat;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.citimate.R;
import com.citimate.adapter.chat.ChatListAdapter;
import com.citimate.bean.chat.ChatListModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ChatFragment extends Fragment {

    private RecyclerView rvChat;
    private LinearLayoutManager layoutManager;
    private ArrayList<ChatListModel> chatListModels;
    private ChatListAdapter chatListAdapter;

    private String[] userName = {"Daniel Burke", "Citimate Team", "Ming Fang", "Liam Ng ", "Jessica Wong"};
    private int[] userProfile = {R.drawable.balak, R.drawable.ic_image_usera, R.drawable.ic_image_userb, R.drawable.ic_image_userc, R.drawable.ic_image_userd};

    public ChatFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_chat, container, false);
        rvChat = (RecyclerView) v.findViewById(R.id.rvChat);
        initialization();
        return v;
    }

    //    Views Id Initialization
    public void initialization() {
        rvChat.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        rvChat.setLayoutManager(layoutManager);
        chatListModels = new ArrayList<>();
        setValues();
    }

    //    Static Data ArrayList Add Method
    private void setValues() {
        for (int i = 0; i < userName.length; i++) {
            ChatListModel listModel = new ChatListModel();
            listModel.setUserProfile(userProfile[i]);
            listModel.setUserName(userName[i]);
            chatListModels.add(listModel);
        }
        chatListAdapter = new ChatListAdapter(getActivity(), chatListModels);
        rvChat.setAdapter(chatListAdapter);
    }
}
