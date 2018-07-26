package com.okawa.store.repository

import io.reactivex.disposables.Disposable

interface AppsRepository {

    fun listApps() : Disposable

}