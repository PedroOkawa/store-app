package com.okawa.store.utils

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.okawa.store.ui.HomeFragment

class MainPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        return when(position) {
            Constants.Home.PAGE_INDEX_HOME -> HomeFragment()
            else -> Fragment()
        }
    }

    override fun getCount() = Constants.Home.MAX_PAGES
}