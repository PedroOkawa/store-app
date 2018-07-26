package com.okawa.store.ui

import android.util.Log
import com.okawa.store.R
import com.okawa.store.data.Result
import com.okawa.store.data.Status
import com.okawa.store.databinding.FragmentHomeBinding
import com.okawa.store.presenter.HomePresenter
import com.okawa.store.ui.base.BaseFragment
import com.okawa.store.ui.model.StoreItemModel
import javax.inject.Inject

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    @Inject
    lateinit var homePresenter: HomePresenter

    override fun layoutToInflate() = R.layout.fragment_home

    override fun doOnCreated() {
        homePresenter.retrieveApps().subscribe { result -> handleResult(result) }
    }

    override fun onDestroy() {
        homePresenter.dispose()
        super.onDestroy()
    }

    private fun handleResult(result: Result<List<StoreItemModel>>) {
        when(result.status) {
            Status.LOADING -> Log.w("TEST", "LOADING")
            Status.ERROR -> Log.w("TEST", "ERROR: ${result.message}")
            Status.SUCCESS ->  {
                defineEditorsChoiceContent(result.data)
                defineLocalTopAppsContent(result.data)
            }
        }
    }

    private fun defineEditorsChoiceContent(storeItemModels: List<StoreItemModel>?) {
        val content = storeItemModels?.filter { storeItemModel ->
            storeItemModel.graphic != null
        }

        Log.w("TEST", "EDITOR'S CHOICE: ${content?.size}")
    }

    private fun defineLocalTopAppsContent(storeItemModels: List<StoreItemModel>?) {
        val content = storeItemModels?.filter { storeItemModel ->
            storeItemModel.graphic == null
        }

        Log.w("TEST", "LOCAL TOP APPS: ${content?.size}")
    }
}