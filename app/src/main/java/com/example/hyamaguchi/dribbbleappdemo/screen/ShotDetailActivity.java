package com.example.hyamaguchi.dribbbleappdemo.screen;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

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
        Shot shot = (Shot)intent.getSerializableExtra("shot");


        Picasso.with(this).load(shot.images.normal).into(imageView);
    }
}
