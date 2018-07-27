package com.okawa.store.ui

import com.okawa.store.R
import com.okawa.store.databinding.ActivityMainBinding
import com.okawa.store.ui.base.BaseActivity
import com.okawa.store.utils.Constants
import com.okawa.store.utils.MainPagerAdapter

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun layoutToInflate() = R.layout.activity_main

    override fun doOnCreated() {
        initViewPager()
        initTabLayout()
    }

    private fun initViewPager() {
        dataBinding.nswMainContent.offscreenPageLimit = Constants.Home.MAX_PAGES
        dataBinding.nswMainContent.adapter = MainPagerAdapter(supportFragmentManager)
        dataBinding.tblMainBottomBar.setupWithViewPager(dataBinding.nswMainContent)
    }

    private fun initTabLayout() {
        dataBinding.tblMainBottomBar.getTabAt(Constants.Home.PAGE_INDEX_HOME)
                ?.setIcon(R.drawable.ic_home)?.setText(R.string.menu_home)
        dataBinding.tblMainBottomBar.getTabAt(Constants.Home.PAGE_INDEX_SEARCH)
                ?.setIcon(R.drawable.ic_search)?.setText(R.string.menu_search)
        dataBinding.tblMainBottomBar.getTabAt(Constants.Home.PAGE_INDEX_STORES)
                ?.setIcon(R.drawable.ic_stores)?.setText(R.string.menu_stores)
        dataBinding.tblMainBottomBar.getTabAt(Constants.Home.PAGE_INDEX_APPS)
                ?.setIcon(R.drawable.ic_apps)?.setText(R.string.menu_apps)
    }

}