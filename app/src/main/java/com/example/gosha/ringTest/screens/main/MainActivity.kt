package com.example.gosha.ringTest.screens.main

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.gosha.ringTest.R
import com.example.gosha.ringTest.core.RingApplication
import com.example.gosha.ringTest.screens.list.ui.ListFragment
import com.example.gosha.ringTest.screens.main.di.DaggerMainActivityComponent
import com.example.gosha.ringTest.screens.main.di.MainActivityComponent
import com.example.gosha.ringTest.screens.main.di.MainActivityModule

class MainActivity : FragmentActivity() {

    val activityComponent: MainActivityComponent by lazy {
        DaggerMainActivityComponent.builder()
            .mainActivityModule(MainActivityModule(this))
            .applicationComponent((application as RingApplication).appComponent)
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent.inject(this)
        supportFragmentManager.beginTransaction()
            .replace(R.id.mainFrame, ListFragment.newInstance(), "TAGG")
            .commit()
    }
}
