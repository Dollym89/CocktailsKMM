package com.example.cocktailskmm.app.di

import org.koin.core.module.Module
import org.koin.dsl.module

internal val applicationModule = module {
    platformDeclaration()
}

internal expect fun Module.platformDeclaration()
