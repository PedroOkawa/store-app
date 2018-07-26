package com.okawa.store.ui

import com.okawa.store.R
import com.okawa.store.databinding.ActivityMainBinding
import com.okawa.store.presenter.MainPresenter
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>() {

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun layoutToInflate() = R.layout.activity_main

    override fun doOnCreated() {

    }

}