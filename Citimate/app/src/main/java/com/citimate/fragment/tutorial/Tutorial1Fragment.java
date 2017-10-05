package com.citimate.fragment.tutorial;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.citimate.R;


public class Tutorial1Fragment extends Fragment implements View.OnClickListener {

    public Tutorial1Fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_tutorial1, container, false);
        return v;
    }

    @Override
    public void onClick(View v) {

    }
}
