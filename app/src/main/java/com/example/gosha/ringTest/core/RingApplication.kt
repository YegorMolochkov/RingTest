package com.example.gosha.ringTest.core

import android.app.Application
import com.example.gosha.ringTest.core.di.ApplicationComponent
import com.example.gosha.ringTest.core.di.ApplicationModule
import com.example.gosha.ringTest.core.di.DaggerApplicationComponent

class RingApplication : Application() {

    val appComponent: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()

    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
    }
}