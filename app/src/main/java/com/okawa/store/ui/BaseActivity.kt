package com.okawa.store.ui

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import dagger.android.support.HasSupportFragmentInjector
import dagger.android.DispatchingAndroidInjector
import javax.inject.Inject

abstract class BaseActivity<T : ViewDataBinding> : AppCompatActivity(), HasSupportFragmentInjector {

    companion object {
        const val DEFAULT_CONTAINER_ID = 0
    }

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>

    protected lateinit var dataBinding: T

    @LayoutRes
    abstract fun layoutToInflate(): Int

    abstract fun doOnCreated()

    @IdRes
    open fun containerId() = DEFAULT_CONTAINER_ID

    open fun initialFragment(): Fragment? = null

    override fun supportFragmentInjector() = fragmentInjector

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        defineDataBinding()

        if (savedInstanceState == null) {
            defineInitialFragment()
        }

        doOnCreated()
    }

    private fun defineDataBinding() {
        dataBinding = DataBindingUtil.setContentView(this, layoutToInflate())
    }

    private fun defineInitialFragment() {
        val initialFragment = initialFragment() ?: return

        if (containerId() != DEFAULT_CONTAINER_ID) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(containerId(), initialFragment)
                    .commitNow()
        }
    }

}