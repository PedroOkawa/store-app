package com.okawa.store.di.module

import com.okawa.store.presenter.HomePresenter
import com.okawa.store.presenter.HomePresenterImpl
import dagger.Binds
import dagger.Module

@Module(includes = [ RepositoryModule::class ])
abstract class HomeModule {

    @Binds
    abstract fun bindsMainPresenter(mainPresenterImpl: HomePresenterImpl): HomePresenter

}