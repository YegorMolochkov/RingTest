package com.example.gosha.ringTest.screens.list.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.gosha.ringTest.domain.feed.FetchFeedUseCase
import com.example.gosha.ringTest.domain.feed.FetchFeedUseCase.FeedResult

class ListViewModel(private val state: MediatorLiveData<State>,
                    private val fetchMemesUseCase: FetchFeedUseCase) : AbstractListViewModel() {

    init {
        state.addSource(fetchMemesUseCase.getLiveData(), ::onFetchMemesResult)
    }

    override fun onCleared() {
        fetchMemesUseCase.cleanUp()
    }

    override fun getState(): LiveData<State> = state

    override fun fetchFeed() {
        state.value = State.ShowLoading
        fetchMemesUseCase.execute()
    }

    private fun onFetchMemesResult(result: FeedResult) {
        when (result) {
            is FeedResult.OnSuccess -> {
                state.value = State.FeedLoaded(result.feed)
                state.value = State.ShowContent
            }
            is FeedResult.OnError -> state.value = State.ShowError
        }
    }
}
