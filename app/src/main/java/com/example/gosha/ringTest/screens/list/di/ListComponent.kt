package com.example.gosha.ringTest.screens.list.di

import com.example.gosha.ringTest.core.di.annotations.ScreenScope
import com.example.gosha.ringTest.screens.list.ui.ListFragment
import com.example.gosha.ringTest.screens.main.di.MainActivityComponent
import dagger.Component

@ScreenScope
@Component(
    dependencies = [MainActivityComponent::class],
    modules = [ListModule::class]
)
interface ListComponent {

    fun inject(fragment: ListFragment)
}