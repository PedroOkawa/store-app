package com.okawa.store

import android.app.Activity
import android.app.Application
import com.okawa.store.di.component.AppTestComponent
import com.okawa.store.di.component.DaggerAppTestComponent
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class AppTest : Application(), HasActivityInjector {

    @Inject
    lateinit var activityInjector: DispatchingAndroidInjector<Activity>

    lateinit var appTestComponent: AppTestComponent

    override fun activityInjector() = activityInjector

    override fun onCreate() {
        appTestComponent = DaggerAppTestComponent.builder().application(this).build()
        super.onCreate()
        appTestComponent.inject(this)
    }

}