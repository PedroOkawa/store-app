package com.okawa.store.presenter

import com.okawa.store.data.Result
import com.okawa.store.repository.AppsRepository
import com.okawa.store.ui.model.StoreItemModel
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import javax.inject.Inject

class HomePresenterImpl @Inject constructor(private val appsRepository: AppsRepository): HomePresenter {

    private var disposable: Disposable? = null

    override fun retrieveResultObserver(consumer: Consumer<Result<List<StoreItemModel>>>) {
        disposable?.dispose()
        disposable = appsRepository.retrieveResultObservable().subscribe(consumer)
    }

    override fun requestApps() {
        appsRepository.requestStoreItems()
    }

    override fun filterByEditorsChoice(data: List<StoreItemModel>?): List<StoreItemModel> =
            data?.filter { storeItemModel -> storeItemModel.graphic != null } ?: ArrayList()

    override fun filterByLocalTopApps(data: List<StoreItemModel>?): List<StoreItemModel> =
            data?.filter { storeItemModel -> storeItemModel.graphic == null } ?: ArrayList()

    override fun dispose() {
        appsRepository.dispose()
        disposable?.dispose()
    }

}