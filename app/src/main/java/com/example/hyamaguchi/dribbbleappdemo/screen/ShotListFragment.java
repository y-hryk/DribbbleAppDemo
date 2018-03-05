package com.example.hyamaguchi.dribbbleappdemo.screen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.hyamaguchi.dribbbleappdemo.R;
import com.example.hyamaguchi.dribbbleappdemo.adapter.ShotRecyclerViewAdapter;
import com.example.hyamaguchi.dribbbleappdemo.dummy.DummyContent.DummyItem;
import com.example.hyamaguchi.dribbbleappdemo.model.Image;
import com.example.hyamaguchi.dribbbleappdemo.model.Shot;
import com.example.hyamaguchi.dribbbleappdemo.network.ShotApi;

import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */

public class ShotListFragment extends Fragment {


    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(Shot shot);
    }

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
//    private OnListFragmentInteractionListener mListener;

    private ShotRecyclerViewAdapter mAdapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ShotListFragment() {

    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static ShotListFragment newInstance(int columnCount) {
        ShotListFragment fragment = new ShotListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shot_list, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        Log.d("debug", "onViewCreated");
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        OnListFragmentInteractionListener listener = new OnListFragmentInteractionListener() {
            @Override
            public void onListFragmentInteraction(Shot shot) {
                Log.d("debug","onListFragmentInteraction");
                Intent intent = new Intent(getActivity(), ShotDetailActivity.class);
                intent.putExtra("shot", shot);
                startActivity(intent);
            }
        };

        mAdapter = new ShotRecyclerViewAdapter(getActivity(), listener);


        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Log.d("debug", "onActivityCreated");


        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        //ログ出力設定
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        httpClient.addInterceptor(logging);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ShotApi.END_POINT)
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();

        Call<List<Shot>> call = retrofit.create(ShotApi.class).fetchShots();
        call.enqueue(new Callback<List<Shot>>() {
            @Override
            public void onResponse(Call<List<Shot>> call, Response<List<Shot>> response) {
                List<Shot> items = response.body();

                Log.d("debug", "通信終わった");
                Log.d("debug", "item名" + items.get(0).user.avatarUrl);
                Log.d("debug", "response: " + response.raw().toString());
                mAdapter.setShots(items);
            }

            @Override
            public void onFailure(Call<List<Shot>> call, Throwable t) {

                Log.d("debug", "通信失敗");
            }
        });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnListFragmentInteractionListener) {
//            mListener = (OnListFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnListFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
//        mListener = null;
    }
}
