package com.okawa.store.repository

import com.okawa.store.api.service.ApiService
import com.okawa.store.data.Result
import com.okawa.store.mapper.StoreItemMapper
import com.okawa.store.ui.model.StoreItemModel
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

class AppsRepositoryImpl @Inject constructor(private val apiService: ApiService, private val storeItemMapper: StoreItemMapper) : BaseRepositoryImpl(), AppsRepository {

    override fun retrieveStoreItems() : Observable<Result<List<StoreItemModel>>> {
        val resultSubject: PublishSubject<Result<List<StoreItemModel>>> = PublishSubject.create()

        request(apiService.listApps()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .flatMap { apiResponse ->
                    Observable.just(apiResponse.responses?.listApps?.dataSets?.all?.data?.list)
                }
                .subscribe({ result ->
                    resultSubject.onNext(Result.success(storeItemMapper.convert(result)))
                }, { error ->
                    resultSubject.onNext(Result.error(error.message, null))
                }))

        resultSubject.onNext(Result.loading(null))

        return resultSubject
    }

}