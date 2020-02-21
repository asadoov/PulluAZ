/*
 * Created by Rufat Asadzade on 20.02.20 11:41
 * Copyright (c) 2020. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pulluaz.CategoryArray;
import com.example.pulluaz.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CategoryAdapter  extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<CategoryArray> data;


    public CategoryAdapter(Context mContext, ArrayList<CategoryArray> mData) {
        this.mContext = mContext;
        this.data = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.card_view,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        CategoryArray categoryItem = data.get(position);
        holder.name.setText(data.get(position).name);

        Picasso.with(mContext).load(categoryItem.catImage)
                .fit()
                .into(holder.icon);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public ImageView icon;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = (TextView)itemView.findViewById(R.id.nameIcon);

            icon=(ImageView)itemView.findViewById(R.id.iconImage);
        }
    }
}
