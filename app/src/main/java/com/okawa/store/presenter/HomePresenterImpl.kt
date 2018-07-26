package com.okawa.store.presenter

import com.okawa.store.repository.AppsRepository
import javax.inject.Inject

class HomePresenterImpl @Inject constructor(private val appsRepository: AppsRepository): HomePresenter {

    override fun retrieveApps() = appsRepository.retrieveStoreItems()

    override fun dispose() {
        appsRepository.dispose()
    }

}