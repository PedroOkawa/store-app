package com.okawa.store.repository

import com.okawa.store.api.service.ApiService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AppsRepositoryImpl @Inject constructor(private val apiService: ApiService) : AppsRepository {

    override fun listApps() : Disposable = apiService.listApps()
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe({ result ->

        }, { error ->

        })

}