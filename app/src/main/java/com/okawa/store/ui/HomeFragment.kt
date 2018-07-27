package com.okawa.store.ui

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.okawa.store.R
import com.okawa.store.data.Result
import com.okawa.store.data.Status
import com.okawa.store.databinding.FragmentHomeBinding
import com.okawa.store.presenter.HomePresenter
import com.okawa.store.ui.base.BaseFragment
import com.okawa.store.ui.model.StoreItemModel
import com.okawa.store.utils.EditorsChoiceAdapter
import com.okawa.store.utils.LocalTopAppsAdapter
import javax.inject.Inject

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    @Inject
    lateinit var homePresenter: HomePresenter

    override fun layoutToInflate() = R.layout.fragment_home

    override fun doOnCreated() {
        initSwipeRefresh()
        requestData()
    }

    override fun onDestroy() {
        homePresenter.dispose()
        super.onDestroy()
    }

    private fun initSwipeRefresh() {
        dataBinding.swpHomeContent.setOnRefreshListener {
            requestData()
        }
    }

    private fun stopSwipeRefresh() {
        dataBinding.swpHomeContent.isRefreshing = false
    }

    private fun requestData() {
        homePresenter.retrieveApps().subscribe { result -> handleResult(result) }
    }

    private fun handleResult(result: Result<List<StoreItemModel>>) {
        when(result.status) {
            Status.LOADING -> Log.w("TEST", "LOADING")
            Status.ERROR -> {
                Toast.makeText(context, result.message, Toast.LENGTH_SHORT).show()
                stopSwipeRefresh()
            }
            Status.SUCCESS ->  {
                stopSwipeRefresh()
                defineEditorsChoiceContent(result.data)
                defineLocalTopAppsContent(result.data)
            }
        }
    }

    private fun defineEditorsChoiceContent(storeItemModels: List<StoreItemModel>?) {
        val content = storeItemModels?.filter { storeItemModel ->
            storeItemModel.graphic != null
        }

        dataBinding.rclHomeEditorsChoiceContent.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        val adapter = EditorsChoiceAdapter()
        adapter.setData(content)
        dataBinding.rclHomeEditorsChoiceContent.adapter = adapter
    }

    private fun defineLocalTopAppsContent(storeItemModels: List<StoreItemModel>?) {
        val content = storeItemModels?.filter { storeItemModel ->
            storeItemModel.graphic == null
        }

        dataBinding.rclHomeLocalTopAppsContent.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        val adapter = LocalTopAppsAdapter()
        adapter.setData(content)
        dataBinding.rclHomeLocalTopAppsContent.adapter = adapter
    }
}