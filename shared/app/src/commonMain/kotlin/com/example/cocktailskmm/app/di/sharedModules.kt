package com.example.cocktailskmm.app.di

import clv.library.activity.di.activityModule
import clv.library.navigation.di.navigationModule
import com.example.ingredient.cocktailskmm.di.ingredientsModule
import com.example.network.di.networkModule
import org.koin.core.KoinApplication

public fun KoinApplication.registerSharedModules() {
    modules(
        listOf(
            activityModule,
            ingredientsModule,
            networkModule,
            navigationModule,

        )
    )
}
