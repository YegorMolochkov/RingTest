package com.example.gosha.ringTest.screens.main.di

import android.content.Context
import com.example.gosha.ringTest.core.di.annotations.ActivityContext
import com.example.gosha.ringTest.core.di.annotations.ActivityScope
import com.example.gosha.ringTest.screens.main.MainActivity
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule(private val activity: MainActivity) {

    @Provides
    @ActivityScope
    fun provideActivity(): MainActivity = activity

    @Provides
    @ActivityContext
    fun provideActivityContext(): Context = activity
}