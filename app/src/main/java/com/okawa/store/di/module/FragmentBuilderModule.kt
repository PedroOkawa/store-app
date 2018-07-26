package com.okawa.store.di.module

import com.okawa.store.ui.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector(modules = [ HomeModule::class ])
    abstract fun contributesHomeFragment(): HomeFragment

}