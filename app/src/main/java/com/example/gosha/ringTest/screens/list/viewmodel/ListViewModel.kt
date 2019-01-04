package com.example.gosha.ringTest.screens.list.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.gosha.ringTest.data.reddit.FeedEntry

abstract class ListViewModel : ViewModel() {

    sealed class State {
        data class FeedLoaded(val feed: List<FeedEntry>) : State()
        object ShowLoading : State()
        object ShowContent : State()
        object ShowError : State()
    }

    abstract fun getState(): LiveData<State>

    abstract fun fetchFeed()
}
