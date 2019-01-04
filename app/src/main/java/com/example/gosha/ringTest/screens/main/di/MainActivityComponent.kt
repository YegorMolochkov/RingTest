package com.example.gosha.ringTest.screens.main.di

import android.content.Context
import com.example.gosha.ringTest.core.di.ApplicationComponent
import com.example.gosha.ringTest.core.di.annotations.ActivityContext
import com.example.gosha.ringTest.core.di.annotations.ActivityScope
import com.example.gosha.ringTest.core.di.annotations.ApplicationContext
import com.example.gosha.ringTest.domain.base.Workers
import com.example.gosha.ringTest.screens.main.MainActivity
import dagger.Component

@ActivityScope
@Component(
    dependencies = [ApplicationComponent::class],
    modules = [MainActivityModule::class]
)
interface MainActivityComponent {

    fun inject(mainActivity: MainActivity)

    @ApplicationContext
    fun applicationContext(): Context

    @ActivityContext
    fun activityContext(): Context

    fun workers(): Workers
}