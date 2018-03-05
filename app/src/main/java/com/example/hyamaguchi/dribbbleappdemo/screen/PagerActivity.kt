package com.example.hyamaguchi.dribbbleappdemo.screen

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.hyamaguchi.dribbbleappdemo.R
import com.example.hyamaguchi.dribbbleappdemo.adapter.PagerAdapter
import kotlinx.android.synthetic.main.activity_pager.*

class PagerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pager)

        setSupportActionBar(toolbar)

        viewPager.adapter = PagerAdapter(supportFragmentManager)
        tabs.setupWithViewPager(viewPager)
    }
}
