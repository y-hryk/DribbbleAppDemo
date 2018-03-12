package com.example.hyamaguchi.dribbbleappdemo.screen;

import android.content.Intent;
import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hyamaguchi.dribbbleappdemo.R;
import com.example.hyamaguchi.dribbbleappdemo.model.Shot;
import com.squareup.picasso.Picasso;

public class ShotDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shot_detail);

        ImageView imageView = findViewById(R.id.image_view);
        Intent intent = getIntent();
        final Shot shot = (Shot)intent.getSerializableExtra("shot");


        Picasso.with(this).load(shot.images.normal).into(imageView);

        Toolbar toolbar = (Toolbar)findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);

        // ステータスバーを消す
//        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);


        if (getSupportActionBar() != null){
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        TextView titleTextView = findViewById(R.id.title_text_view);
        titleTextView.setText(shot.title);


        TextView viewCountTextView = findViewById(R.id.view_count_text_view);
        viewCountTextView.setText("ViewCount " + shot.viewsCount);

        TextView detailTextView = findViewById(R.id.detail_text_view);
        detailTextView.setText(shot.description);


        final CollapsingToolbarLayout toolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        AppBarLayout appBarLayout = (AppBarLayout) findViewById(R.id.app_bar_layout);
        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            boolean isShow = true;
            int scrollRange = -1;

            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (scrollRange == -1) {
                    scrollRange = appBarLayout.getTotalScrollRange();
                }
                if (scrollRange + verticalOffset == 0) {
                    toolbarLayout.setTitle(shot.title);
                    isShow = true;
                } else if(isShow) {
                    toolbarLayout.setTitle(" ");//carefull there should a space between double quote otherwise it wont work
                    isShow = false;
                }
            }
        });
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
