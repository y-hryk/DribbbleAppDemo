package com.example.hyamaguchi.dribbbleappdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hyamaguchi.dribbbleappdemo.ShotListFragment.OnListFragmentInteractionListener;
import com.example.hyamaguchi.dribbbleappdemo.dummy.DummyContent.DummyItem;
import com.example.hyamaguchi.dribbbleappdemo.model.Shot;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class ShotRecyclerViewAdapter extends RecyclerView.Adapter<ShotRecyclerViewAdapter.ViewHolder> {

    private final ArrayList<Shot> items;
//    private final OnListFragmentInteractionListener mListener;

    public ShotRecyclerViewAdapter(ArrayList<Shot> items, OnListFragmentInteractionListener listener) {
        this.items = items;
//        mListener = listener;
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
        holder.shot = items.get(position);
        holder.mTitleTextView.setText(holder.shot.title);
//        holder.mDetailTextView.setText(holder.shot.userName);

//        holder.itemView

//        holder.mIdView.setText(mValues.get(position).id);
//        holder.mContentView.setText(mValues.get(position).content);

//        holder.mView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if (null != mListener) {
//                    // Notify the active callbacks interface (the activity, if the
//                    // fragment is attached to one) that an item has been selected.
//                    mListener.onListFragmentInteraction(holder.mItem);
//                }
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public final TextView mTitleTextView;
        public final TextView mDetailTextView;
        public Shot shot;

        public ViewHolder(View view) {
            super(view);
            mTitleTextView = view.findViewById(R.id.item_title_text_view);
            mDetailTextView = view.findViewById(R.id.item_detail_text_view);
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
