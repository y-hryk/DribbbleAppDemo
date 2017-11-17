package com.example.hyamaguchi.dribbbleappdemo
//import  com.example.hyamaguchi.dribbbleappdemo.ItemListFragment

import android.os.Bundle

import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

/**
 * Created by h.yamaguchi on 2017/11/17.
 */

class PagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    private val fragments = ArrayList<Fragment>()

    init {

    }

    override fun getItem(position: Int): Fragment {
//        val args = Bundle()
//        args.putInt(SECTION_NUMBER, position)
//        val fragment = mFragments[position]
//        fragment.arguments = args
        return ItemListFragment()
    }


    override fun getCount(): Int {
        return 6
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "Popular"
            1 -> return "Teams"
            2 -> return "Rebounds"
            3 -> return "test"
            4 -> return "test"
            5 -> return "test"
        }
        return null
    }

}
