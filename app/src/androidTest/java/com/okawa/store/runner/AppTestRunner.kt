package com.okawa.store.runner

import android.app.Application
import android.content.Context
import android.support.test.runner.AndroidJUnitRunner
import com.okawa.store.AppTest

class AppTestRunner : AndroidJUnitRunner() {

    override fun newApplication(cl: ClassLoader?, className: String?, context: Context?): Application {
        return super.newApplication(cl, AppTest::class.java.name, context)
    }

}