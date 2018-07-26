package com.okawa.store.di.module

import com.okawa.store.repository.AppsRepository
import com.okawa.store.repository.AppsRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindsAppsRepository(appsRepositoryImpl: AppsRepositoryImpl): AppsRepository

}