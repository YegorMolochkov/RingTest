package com.example.gosha.ringTest.core.di

import android.content.Context
import com.example.gosha.ringTest.core.RingApplication
import com.example.gosha.ringTest.core.di.annotations.ApplicationContext
import dagger.Module
import dagger.Provides


@Module
class ApplicationModule(var application: RingApplication) {


    @Provides
    @ApplicationContext
    fun providesApplicationContext(): Context = application
}