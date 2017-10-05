package com.citimate.fragment.tutorial;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.citimate.R;
import com.citimate.activity.LoginActivity;

public class Tutorial4Fragment extends Fragment {

    private TextView tvGotIt;

    public Tutorial4Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tutorial4, container, false);
        tvGotIt = (TextView) v.findViewById(R.id.tvGotIt);

        tvGotIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                getActivity().overridePendingTransition(0, 0);
                getActivity().finish();
            }
        });
        return v;
    }
}
