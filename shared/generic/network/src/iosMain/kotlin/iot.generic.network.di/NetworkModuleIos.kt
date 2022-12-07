package com.example.network.di

import clv.library.koin.di.factoryOf
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin
import org.koin.core.module.Module

internal actual fun Module.platformDeclaration() {
    factoryOf(::httpClientEngine)
}

private fun httpClientEngine(): HttpClientEngine = Darwin.create {
}
