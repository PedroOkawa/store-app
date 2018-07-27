package com.okawa.store.presenter

import com.okawa.store.data.Result
import com.okawa.store.ui.model.StoreItemModel
import io.reactivex.functions.Consumer

interface HomePresenter {

    fun retrieveResultObserver(consumer: Consumer<Result<List<StoreItemModel>>>)

    fun requestApps()

    fun filterByEditorsChoice(data: List<StoreItemModel>?) : List<StoreItemModel>

    fun filterByLocalTopApps(data: List<StoreItemModel>?) : List<StoreItemModel>

    fun dispose()

}