package com.okawa.store.repository

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseRepositoryImpl {

    private var disposables = CompositeDisposable()

    fun request(disposable: Disposable) {
        dispose()
        disposables.add(disposable)
    }

    fun dispose() {
        disposables.dispose()
        disposables = CompositeDisposable()
    }

}