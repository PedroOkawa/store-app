package com.okawa.store.di.module

import com.okawa.store.presenter.MainPresenter
import com.okawa.store.presenter.MainPresenterImpl
import dagger.Binds
import dagger.Module

@Module(includes = [ RepositoryModule::class ])
abstract class MainModule {

    @Binds
    abstract fun bindsMainPresenter(mainPresenterImpl: MainPresenterImpl): MainPresenter

}