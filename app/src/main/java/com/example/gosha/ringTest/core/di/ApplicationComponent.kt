package com.example.gosha.ringTest.core.di

import android.content.Context
import com.example.gosha.ringTest.core.RingApplication
import com.example.gosha.ringTest.core.di.annotations.ApplicationContext
import com.example.gosha.ringTest.domain.base.Workers
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(application: RingApplication)

    @ApplicationContext
    fun applicationContext(): Context

    fun workers(): Workers
}