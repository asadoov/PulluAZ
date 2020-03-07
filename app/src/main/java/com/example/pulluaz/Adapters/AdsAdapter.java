/*
 * Created by Rufat Asadzade on 28.02.20 15:32
 * Copyright (c) 2020. Rufat Asadzade. All rights reserved.
 */

package com.example.pulluaz.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pulluaz.CategoryArray;
import com.example.pulluaz.DetailAdsActivity;
import com.example.pulluaz.R;
import com.example.pulluaz.adView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class AdsAdapter extends RecyclerView.Adapter<AdsAdapter.MyViewHolder>{
    private Context mContext;
    private ArrayList<adView> data;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }


    public AdsAdapter(Context mContext, ArrayList<adView> mData) {
        this.mContext = mContext;
        this.data = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.card_view_ads,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        adView adsView = data.get(position);

        holder.txtAds.setText(data.get(position).aTypeName);
//        holder.txtName.setText(data.get(position).sellerFullName);
        holder.txtTitle.setText(data.get(position).name);
        holder.txtAdsSector.setText(data.get(position).catName);
        holder.txtDesc.setText(data.get(position).description);
        holder.txtDate.setText(data.get(position).cDate.toString());


        Picasso.with(mContext).load(adsView.photoUrl.get(0))
                .fit().centerCrop()
                .into(holder.adsImg);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name;
        public TextView txtAdsSector;
        public TextView txtTitle;
        public TextView txtDesc;
        public TextView txtDate;
        public TextView txtAds;
        public TextView txtName;
        public TextView watch;
        public ImageView adsImg;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtAdsSector = (TextView)itemView.findViewById(R.id.txtAdsSector);
            txtTitle = (TextView)itemView.findViewById(R.id.txtTitle);
            txtDesc = (TextView)itemView.findViewById(R.id.txtDesc);
            txtDate = (TextView)itemView.findViewById(R.id.txtDate);
            txtAds = (TextView)itemView.findViewById(R.id.txtAds);
            txtName = (TextView)itemView.findViewById(R.id.sellerName);
            name = (TextView)itemView.findViewById(R.id.nameCat);
         //   watch = (TextView)itemView.findViewById(R.id.txtWatch);
            adsImg=(ImageView)itemView.findViewById(R.id.imgAds1);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mListener!=null){
                        int position = getAdapterPosition();
                        if (position!=RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }


    }
}
