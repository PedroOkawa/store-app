package com.okawa.store.di.module

import android.app.Application
import com.google.gson.Gson
import com.okawa.store.utils.ApiManager
import com.okawa.store.utils.FileHelper
import dagger.Module
import dagger.Provides
import org.mockito.Mockito.mock
import javax.inject.Singleton

@Module
class UtilsTestModule {

    @Singleton
    @Provides
    fun providesApiManager(): ApiManager {
        return mock(ApiManager::class.java)
    }

    @Singleton
    @Provides
    fun provideFileHelper(app: Application, gson: Gson) = FileHelper(app, gson)

}