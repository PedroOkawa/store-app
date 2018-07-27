package com.okawa.store.utils

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.okawa.store.ui.HomeFragment
import com.okawa.store.ui.MainActivity

class MainPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    companion object {
        private const val MAX_PAGES = 4
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            MainActivity.PAGE_INDEX_HOME -> HomeFragment()
            else -> Fragment()
        }
    }

    override fun getCount() = MAX_PAGES
}