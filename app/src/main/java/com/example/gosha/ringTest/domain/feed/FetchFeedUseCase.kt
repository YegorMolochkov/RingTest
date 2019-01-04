package com.example.gosha.ringTest.domain.feed

import com.example.gosha.ringTest.data.reddit.FeedEntry
import com.example.gosha.ringTest.domain.base.UseCase

interface FetchFeedUseCase : UseCase<FetchFeedUseCase.FeedResult> {

    sealed class FeedResult {
        data class OnSuccess(val feed: List<FeedEntry>) : FeedResult()
        object OnError : FeedResult()
    }

    fun execute()
}
