package com.citimate.activity;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.citimate.R;
import com.citimate.adapter.chat.ChatMessageListAdapter;
import com.citimate.bean.chat.ChatMessagesListModel;

import java.util.ArrayList;

public class ChatViewActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView rvChatList;
    private LinearLayoutManager layoutManager;
    private ArrayList<ChatMessagesListModel> chatMessagesListModels;
    private ChatMessageListAdapter chatMessageListAdapter;
    private ImageView iv_back_button;

    private ImageView tvAa, tvHeart, tvBeer, tvRequest, sendBtn;

    private String[] message = {"Hello, I am waiting...", "For What?", "I am super Hungury...", "Hey, want to go drink?"};
    private String[] time = {"5 min Ago", "4 min Ago", "3 min Ago", "2 min Ago"};
    private String[] type = {"reciver", "sender", "reciver", "sender"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_view);
        initialization();
    }

    public void initialization() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.color_yellow));
        }

//        ImageView Id
        iv_back_button = (ImageView) findViewById(R.id.iv_back_button);
        tvAa = (ImageView) findViewById(R.id.tvAa);
        tvHeart = (ImageView) findViewById(R.id.tvHeart);
        tvBeer = (ImageView) findViewById(R.id.tvBeer);
        tvRequest = (ImageView) findViewById(R.id.tvRequest);
        sendBtn = (ImageView) findViewById(R.id.sendBtn);

//        TextView Id
        TextView tv_title_toolbar = (TextView) findViewById(R.id.tv_title_toolbar);
        tv_title_toolbar.setText(getIntent().getStringExtra("UserName"));

//        Click Listener
        iv_back_button.setOnClickListener(this);
        tvAa.setOnClickListener(this);
        tvHeart.setOnClickListener(this);
        tvBeer.setOnClickListener(this);
        tvRequest.setOnClickListener(this);
        sendBtn.setOnClickListener(this);

//        RecyclerView Setup
        rvChatList = (RecyclerView) findViewById(R.id.rvChatList);
        rvChatList.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(ChatViewActivity.this);
        layoutManager.setOrientation(LinearLayout.VERTICAL);
        layoutManager.setStackFromEnd(true);
        rvChatList.setLayoutManager(layoutManager);
        chatMessagesListModels = new ArrayList<>();
        setValues();
    }

    //    Static Data Set Method
    private void setValues() {
        for (int i = 0; i < message.length; i++) {
            ChatMessagesListModel listModel = new ChatMessagesListModel();
            listModel.setMessage(message[i]);
            listModel.setTime(time[i]);
            listModel.setType(type[i]);
            chatMessagesListModels.add(listModel);
        }
        chatMessageListAdapter = new ChatMessageListAdapter(ChatViewActivity.this, chatMessagesListModels);
        rvChatList.setAdapter(chatMessageListAdapter);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.iv_back_button:
                finish();
                break;

            case R.id.tvAa:
                Toast.makeText(ChatViewActivity.this, "In progress", Toast.LENGTH_SHORT).show();
                break;

            case R.id.tvHeart:
                Toast.makeText(ChatViewActivity.this, "In progress", Toast.LENGTH_SHORT).show();
                break;

            case R.id.tvBeer:
                Toast.makeText(ChatViewActivity.this, "In progress", Toast.LENGTH_SHORT).show();
                break;

            case R.id.tvRequest:
                Toast.makeText(ChatViewActivity.this, "In progress", Toast.LENGTH_SHORT).show();
                break;

            case R.id.sendBtn:
                Toast.makeText(ChatViewActivity.this, "In progress", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
