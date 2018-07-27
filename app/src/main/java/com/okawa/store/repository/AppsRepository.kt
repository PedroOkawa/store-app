package com.okawa.store.repository

import com.okawa.store.data.Result
import com.okawa.store.ui.model.StoreItemModel
import io.reactivex.Observable

interface AppsRepository {

    fun retrieveResultObservable() : Observable<Result<List<StoreItemModel>>>

    fun requestStoreItems()

    fun dispose()

}