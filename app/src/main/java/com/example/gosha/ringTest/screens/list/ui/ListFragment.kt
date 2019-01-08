package com.example.gosha.ringTest.screens.list.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gosha.ringTest.R
import com.example.gosha.ringTest.core.observe
import com.example.gosha.ringTest.screens.list.di.DaggerListComponent
import com.example.gosha.ringTest.screens.list.di.ListModule
import com.example.gosha.ringTest.screens.list.viewmodel.AbstractListViewModel
import com.example.gosha.ringTest.screens.list.viewmodel.AbstractListViewModel.State
import com.example.gosha.ringTest.screens.main.MainActivity
import kotlinx.android.synthetic.main.fragment_list.*
import javax.inject.Inject

class ListFragment : Fragment() {

    companion object {

        fun newInstance() = ListFragment()
    }

    private val component by lazy {
        DaggerListComponent.builder()
            .mainActivityComponent((activity as MainActivity).activityComponent)
            .listModule(ListModule())
            .build()
    }

    @Inject
    lateinit var viewModel: AbstractListViewModel
    private lateinit var adapter: ListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        component.inject(this)
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpList()
        setUpViewModelStateObservers()
        viewModel.fetchFeed()
    }

    private fun setUpList() {
        adapter = ListAdapter()
        listRv.layoutManager = LinearLayoutManager(activity)
        listRv.adapter = adapter
    }

    private fun setUpViewModelStateObservers() {
        observe(viewModel.getState()) { onStateChanged(it) }
    }

    private fun onStateChanged(state: State) = when (state) {
        is State.FeedLoaded -> adapter.addItems(state.feed)
        State.ShowLoading -> {
        }
        State.ShowContent -> {
        }
        State.ShowError -> {
        }
    }
}