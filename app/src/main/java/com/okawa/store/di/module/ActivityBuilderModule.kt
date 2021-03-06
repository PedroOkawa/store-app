package com.okawa.store.di.module

import com.okawa.store.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [ FragmentBuilderModule::class ])
    abstract fun contributesMainActivity(): MainActivity

}