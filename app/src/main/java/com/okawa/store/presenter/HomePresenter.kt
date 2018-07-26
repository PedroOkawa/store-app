package com.okawa.store.presenter

import com.okawa.store.data.Result
import com.okawa.store.ui.model.StoreItemModel
import io.reactivex.Observable

interface HomePresenter {

    fun retrieveApps() : Observable<Result<List<StoreItemModel>>>

    fun dispose()

}