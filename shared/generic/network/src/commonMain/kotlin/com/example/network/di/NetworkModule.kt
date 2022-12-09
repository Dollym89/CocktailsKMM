package com.example.network.di

import clv.library.koin.di.factoryOf
import kotlinx.serialization.json.Json
import org.koin.core.module.Module
import org.koin.dsl.module

public val networkModule: Module = module {
    single { Json { ignoreUnknownKeys = true } }
    factoryOf(::httpClient)

    platformDeclaration()
}

internal expect fun Module.platformDeclaration()
