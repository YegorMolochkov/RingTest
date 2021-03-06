package com.example.gosha.ringTest.screens.list.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gosha.ringTest.R
import com.example.gosha.ringTest.data.reddit.FeedEntry
import kotlinx.android.synthetic.main.item_feed.view.*
import java.util.concurrent.TimeUnit

class ListAdapter : RecyclerView.Adapter<FeedViewHolder>() {

    private val feed: MutableList<FeedEntry> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_feed, parent, false)
        return FeedViewHolder(view)
    }

    override fun getItemCount(): Int = feed.size


    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {
        holder.bind(feed[position])
    }

    fun addItems(items: List<FeedEntry>) {
        feed.addAll(items)
        notifyDataSetChanged()
    }
}

class FeedViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(entry: FeedEntry) = with(entry) {
        val hoursAgo = TimeUnit.MILLISECONDS.toHours(System.currentTimeMillis() - date).toInt()
        view.infoTv.text = view.context.resources.getQuantityString(R.plurals.entry_info, hoursAgo, author, hoursAgo)
        view.contentTv.text = title
        view.commentsNumberTv.text =
                view.context.resources.getQuantityString(R.plurals.comments_number, commentsNumber, commentsNumber)
    }
}
