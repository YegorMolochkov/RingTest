package com.example.gosha.ringTest.domain.feed

import com.example.gosha.ringTest.data.reddit.FeedEntry
import com.example.gosha.ringTest.data.reddit.RedditRepository
import com.example.gosha.ringTest.domain.base.BaseUseCase
import com.example.gosha.ringTest.domain.base.Workers
import timber.log.Timber

class RxFetchFeedUseCase(private val repository: RedditRepository,
                         private val workers: Workers) :
    BaseUseCase<FetchFeedUseCase.FeedResult>(), FetchFeedUseCase {

    override fun execute() {
        repository.getFeed()
            .subscribeOn(workers.subscribe)
            .observeOn(workers.observe)
            .subscribe(::success, ::error)
            .track()
    }

    private fun success(feed: List<FeedEntry>) {
        liveData.value = FetchFeedUseCase.FeedResult.OnSuccess(feed)
    }

    private fun error(throwable: Throwable) {
        Timber.e(throwable)
        liveData.value = FetchFeedUseCase.FeedResult.OnError
    }
}