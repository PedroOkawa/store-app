package com.okawa.store.ui

import com.okawa.store.R
import com.okawa.store.databinding.ActivityMainBinding
import com.okawa.store.ui.base.BaseActivity
import com.okawa.store.utils.MainPagerAdapter

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun layoutToInflate() = R.layout.activity_main

    override fun doOnCreated() {
        initViewPager()
    }

    private fun initViewPager() {
        dataBinding.vwpMainContent.offscreenPageLimit = 4
        dataBinding.vwpMainContent.adapter = MainPagerAdapter(supportFragmentManager)
        dataBinding.tblMainBottomBar.setupWithViewPager(dataBinding.vwpMainContent)
    }

}