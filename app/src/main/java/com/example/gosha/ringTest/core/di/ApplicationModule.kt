package com.example.gosha.ringTest.core.di

import android.content.Context
import com.example.gosha.ringTest.core.RingApplication
import com.example.gosha.ringTest.core.di.annotations.ApplicationContext
import com.example.gosha.ringTest.domain.base.Workers
import dagger.Module
import dagger.Provides
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Singleton


@Module
class ApplicationModule(var application: RingApplication) {

    @Provides
    @ApplicationContext
    fun providesApplicationContext(): Context = application

    @Provides
    @Singleton
    fun provideWorkers(): Workers = Workers(Schedulers.io(), AndroidSchedulers.mainThread())
}