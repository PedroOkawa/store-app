package com.okawa.store.di.component

import android.app.Application
import com.okawa.store.AppTest
import com.okawa.store.di.module.ActivityBuilderModule
import com.okawa.store.di.module.ApiModule
import com.okawa.store.di.module.UtilsTestModule
import com.okawa.store.suite.HomeFragmentTest
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    ActivityBuilderModule::class,
    AndroidSupportInjectionModule::class,
    ApiModule::class,
    UtilsTestModule::class
])
interface AppTestComponent : AndroidInjector<AppTest> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppTestComponent
    }

    override fun inject(appTest: AppTest)

    fun inject(homeFragmentTest: HomeFragmentTest)

}