package com.okawa.store.di.module

import com.okawa.store.api.service.ApiService
import com.okawa.store.utils.ApiManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UtilsModule {

    @Singleton
    @Provides
    fun providesApiManager(apiService: ApiService) = ApiManager(apiService)

}