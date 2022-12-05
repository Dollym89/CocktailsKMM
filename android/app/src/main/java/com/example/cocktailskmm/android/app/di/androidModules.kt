package com.example.cocktailskmm.android.app.di

import org.koin.core.KoinApplication

internal fun KoinApplication.registerAndroidModules() {
    modules(androidModule)
}