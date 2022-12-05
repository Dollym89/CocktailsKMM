package com.example.cocktailskmm.android.app.system

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val lifecycle: MainActivityLifecycle by inject()

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(lifecycle.onCreate(savedInstanceState))
        // TODO set compose view
    }
}
