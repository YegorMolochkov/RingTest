package com.example.gosha.ringTest.data.reddit

data class FeedEntry(val title: String,
                     val author: String,
                     val date: Long,
                     val image: String?,
                     val commentsNumber: Int)