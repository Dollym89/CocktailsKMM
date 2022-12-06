package com.example.cocktailskmm.app.di

import clv.library.activity.di.activityModule
import clv.library.navigation.di.navigationModule
import org.koin.core.KoinApplication

public fun KoinApplication.registerSharedModules() {
    modules(
        listOf(
            activityModule,
            navigationModule,
        )
    )
}
