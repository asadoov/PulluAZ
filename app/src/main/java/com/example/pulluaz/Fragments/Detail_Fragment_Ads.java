/*
 * Created by Rufat Asadzade on 05.03.20 13:14
 * Copyright (c) 2020. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pulluaz.R;

import static com.example.pulluaz.Fragments.HomeFragment.EXTRA_ADS_DESC;
import static com.example.pulluaz.Fragments.HomeFragment.EXTRA_ADS_NAME;

public class Detail_Fragment_Ads extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.detail__fragment__ads, container, false);




        Intent intent = getActivity().getIntent();
        String name = intent.getStringExtra(EXTRA_ADS_NAME);
        String desc = intent.getStringExtra(EXTRA_ADS_DESC);

        TextView nameText= (TextView)v.findViewById(R.id.name);
        nameText.setText(name);
        TextView descText= (TextView)v.findViewById(R.id.detail_desc);
        descText.setText(desc);




        return v;
    }



}
