package com.okawa.store.ui

import android.util.Log
import com.okawa.store.R
import com.okawa.store.data.Result
import com.okawa.store.data.Status
import com.okawa.store.databinding.ActivityMainBinding
import com.okawa.store.presenter.MainPresenter
import com.okawa.store.ui.base.BaseActivity
import com.okawa.store.ui.model.StoreItemModel
import javax.inject.Inject

class MainActivity : BaseActivity<ActivityMainBinding>() {

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun layoutToInflate() = R.layout.activity_main

    override fun doOnCreated() {
        mainPresenter.retrieveApps().subscribe { result -> handleResult(result) }
    }

    override fun onDestroy() {
        mainPresenter.dispose()
        super.onDestroy()
    }

    private fun handleResult(result: Result<List<StoreItemModel>>) {
        when(result.status) {
            Status.LOADING -> Log.w("TEST", "LOADING")
            Status.ERROR -> Log.w("TEST", "ERROR: ${result.message}")
            Status.SUCCESS ->  defineEditorsChoiceContent(result.data)
        }
    }

    private fun defineEditorsChoiceContent(storeItemModels: List<StoreItemModel>?) {
        val content = storeItemModels?.filter { storeItemModel ->
            storeItemModel.graphic != null
        }
    }

    private fun defineLocalTopAppsContent(storeItemModels: List<StoreItemModel>?) {
        val content = storeItemModels?.filter { storeItemModel ->
            storeItemModel.graphic == null
        }
    }

}