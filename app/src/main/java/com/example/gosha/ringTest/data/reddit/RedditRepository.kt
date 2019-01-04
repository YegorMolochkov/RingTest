package com.example.gosha.ringTest.data.reddit

import io.reactivex.Single

interface RedditRepository {

    fun getFeed(): Single<List<FeedEntry>>
}