package com.example.cocktailskmm.android.app.system

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import clv.library.navigation.system.NavigationActivityDelegate
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val lifecycle: MainActivityLifecycle by inject()
    private val navigationDelegate: NavigationActivityDelegate by inject()

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(lifecycle.onCreate(savedInstanceState))
        // TODO set compose view
    }

    override fun onStart() {
        super.onStart()
        navigationDelegate.onStart(this)
    }

    override fun onStop() {
        navigationDelegate.onStop()
        super.onStop()
    }
}
