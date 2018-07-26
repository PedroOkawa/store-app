package com.okawa.store.presenter

import com.okawa.store.repository.AppsRepository
import javax.inject.Inject

class MainPresenterImpl @Inject constructor(private val appsRepository: AppsRepository): MainPresenter {

}