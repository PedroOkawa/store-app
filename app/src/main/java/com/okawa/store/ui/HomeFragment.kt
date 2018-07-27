package com.okawa.store.ui

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
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
import io.reactivex.functions.Consumer
import javax.inject.Inject

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    @Inject
    lateinit var homePresenter: HomePresenter

    private val editorsChoiceAdapter = EditorsChoiceAdapter()
    private val localTopAppsAdapter = LocalTopAppsAdapter()

    override fun layoutToInflate() = R.layout.fragment_home

    override fun doOnCreated() {
        initContentView()
        initSwipeRefresh()
        initResultObserver()
        requestData()
    }

    override fun onDestroyView() {
        homePresenter.dispose()
        super.onDestroyView()
    }

    private fun initContentView() {
        dataBinding.rclHomeEditorsChoiceContent.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        dataBinding.rclHomeEditorsChoiceContent.adapter = editorsChoiceAdapter
        dataBinding.rclHomeLocalTopAppsContent.layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
        dataBinding.rclHomeLocalTopAppsContent.adapter = localTopAppsAdapter
    }

    private fun initSwipeRefresh() {
        dataBinding.swpHomeContent.setOnRefreshListener {
            requestData()
        }
    }

    private fun initResultObserver() {
        homePresenter.retrieveResultObserver(Consumer { result ->
            handleResult(result)
        })
    }

    private fun stopSwipeRefresh() {
        dataBinding.swpHomeContent.isRefreshing = false
    }

    private fun requestData() {
        homePresenter.requestApps()
    }

    private fun handleResult(result: Result<List<StoreItemModel>>) {
        when(result.status) {
            Status.LOADING -> {
                //dataBinding.loading = true
            }
            Status.ERROR -> {
                stopSwipeRefresh()
                //dataBinding.loading = false
                Toast.makeText(context, result.message, Toast.LENGTH_SHORT).show()
            }
            Status.SUCCESS ->  {
                stopSwipeRefresh()
                //dataBinding.loading = false
                defineEditorsChoiceContent(result.data)
                defineLocalTopAppsContent(result.data)
            }
        }
    }

    private fun defineEditorsChoiceContent(storeItemModels: List<StoreItemModel>?) {
        editorsChoiceAdapter.setData(homePresenter.filterByEditorsChoice(storeItemModels))
    }

    private fun defineLocalTopAppsContent(storeItemModels: List<StoreItemModel>?) {
        localTopAppsAdapter.setData(homePresenter.filterByLocalTopApps(storeItemModels))
    }
}