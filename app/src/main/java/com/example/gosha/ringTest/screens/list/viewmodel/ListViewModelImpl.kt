package com.example.gosha.ringTest.screens.list.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.example.gosha.ringTest.domain.feed.FetchFeedUseCase

class ListViewModelImpl(private val state: MediatorLiveData<State>,
                        private val fetchMemesUseCase: FetchFeedUseCase) : ListViewModel() {

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

    private fun onFetchMemesResult(result: FetchFeedUseCase.FeedResult) {
        when (result) {
            is FetchFeedUseCase.FeedResult.OnSuccess -> {
                state.value = State.FeedLoaded(result.feed)
                state.value = State.ShowContent
            }
            is FetchFeedUseCase.FeedResult.OnError -> state.value = State.ShowError
        }
    }
}
