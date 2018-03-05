package com.example.hyamaguchi.dribbbleappdemo.adapter;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hyamaguchi.dribbbleappdemo.R;
import com.example.hyamaguchi.dribbbleappdemo.screen.ShotListFragment.OnListFragmentInteractionListener;
import com.example.hyamaguchi.dribbbleappdemo.dummy.DummyContent.DummyItem;
import com.example.hyamaguchi.dribbbleappdemo.model.Shot;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ShotRecyclerViewAdapter extends RecyclerView.Adapter<ShotRecyclerViewAdapter.ViewHolder> {

    private ArrayList<Shot> items;
    private Context context;
    private final OnListFragmentInteractionListener mListener;

    public ShotRecyclerViewAdapter(Context context, OnListFragmentInteractionListener listener) {
//        this.items = items;
        this.items = new ArrayList<>();
        this.context = context;
        this.mListener = listener;
    }

    public void setShots(List<Shot> shots) {

//        this.items = shots.toArray();
        for (Shot shot : shots) {
            this.items.add(shot);
        }
        this.notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cell, parent, false);
        return new ViewHolder(view);
    }

    // viewにデータを詰める
    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        // モデルをセットする
        holder.shot = items.get(position);
        holder.mTitleTextView.setText(holder.shot.title);
        holder.mDetailTextView.setText(holder.shot.user.name);
        Picasso.with(this.context).load(holder.shot.images.normal).into(holder.mImageView);
        Picasso.with(this.context).load(holder.shot.user.avatarUrl).into(holder.mIconImageView);

        holder.mCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    mListener.onListFragmentInteraction(holder.shot);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final CardView mCardView;
        public final TextView mTitleTextView;
        public final TextView mDetailTextView;
        public final ImageView mImageView;
        public final ImageView mIconImageView;
        public Shot shot;

        public ViewHolder(View view) {
            super(view);
            mCardView = view.findViewById(R.id.card_view);
            mTitleTextView = view.findViewById(R.id.item_title_text_view);
            mDetailTextView = view.findViewById(R.id.item_detail_text_view);
            mImageView = view.findViewById(R.id.image_view);
            mIconImageView = view.findViewById(R.id.icon_image_view);

//            mIdView = (TextView) view.findViewById(R.id.id);
//            mContentView = (TextView) view.findViewById(R.id.content);
        }

        // デバック用の ios のdescription
        @Override
        public String toString() {
//            return super.toString() + " '" + mContentView.getText() + "'";
            return "ssss";
        }
    }
}
