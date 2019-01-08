package com.example.gosha.ringTest.screens.list.di

import androidx.lifecycle.MediatorLiveData
import com.example.gosha.ringTest.core.di.annotations.ScreenScope
import com.example.gosha.ringTest.data.reddit.RedditRepository
import com.example.gosha.ringTest.data.reddit.StubRedditRepository
import com.example.gosha.ringTest.domain.base.Workers
import com.example.gosha.ringTest.domain.feed.FetchFeedUseCase
import com.example.gosha.ringTest.domain.feed.RxFetchFeedUseCase
import com.example.gosha.ringTest.screens.list.viewmodel.AbstractListViewModel
import com.example.gosha.ringTest.screens.list.viewmodel.ListViewModel
import dagger.Module
import dagger.Provides

@Module
class ListModule {

    @Provides
    @ScreenScope
    fun provideRepository(): RedditRepository = StubRedditRepository()

    @Provides
    @ScreenScope
    fun provideUseCase(repository: RedditRepository, workers: Workers): FetchFeedUseCase =
        RxFetchFeedUseCase(repository, workers)

    @Provides
    @ScreenScope
    fun provideViewModel(useCase: FetchFeedUseCase): AbstractListViewModel =
        ListViewModel(MediatorLiveData(), useCase)
}