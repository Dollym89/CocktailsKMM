package com.example.cocktailskmm.android.app.system

import android.os.Bundle
import clv.library.logger.infrastructure.logI
import clv.library.logger.infrastructure.logV

internal class MainActivityLifecycle {

    private var activityCreatedMarker = false

    fun onCreate(savedInstanceState: Bundle?): Bundle? = when {
        hasBeenKilled(savedInstanceState) -> {
            logI("Application has been probably killed by the OS. Resetting...")
            null
        }
        else -> {
            activityCreatedMarker = true
            savedInstanceState
        }
    }

    private fun hasBeenKilled(savedInstanceState: Bundle?): Boolean {
        val result = savedInstanceState != null && !activityCreatedMarker
        logV(
            "Kill detection: savedInstanceState=${savedInstanceState != null}, " +
                "marker=$activityCreatedMarker, killed=$result",
        )
        return result
    }
}
