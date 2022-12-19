package com.example.cocktailskmm.app.di

import clv.library.activity.di.activityModule
import clv.library.navigation.di.navigationModule
import com.cocktails.di.ingredientsDatabaseModule
import com.ingredient.cocktails.di.ingredientsModule
import com.example.network.di.networkModule
import org.koin.core.KoinApplication

public fun KoinApplication.registerSharedModules() {
    modules(
        listOf(
            activityModule,
            ingredientsDatabaseModule,
            ingredientsModule,
            networkModule,
            navigationModule,
        )
    )
}
