package com.example.network.di

import io.ktor.client.HttpClient
import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import com.example.network.data.NetworkLogger
import kotlinx.serialization.json.Json

internal fun httpClient(
    httpClientEngine: HttpClientEngine,
) = HttpClient(httpClientEngine) {

    @Suppress("MagicNumber")
    install(HttpTimeout) {
        requestTimeoutMillis = 15_000
        connectTimeoutMillis = 15_000
    }

    install(ContentNegotiation) {
        Json {
            ignoreUnknownKeys = true
        }
    }

    // Throws an exception for non 2xx response codes
    expectSuccess = true

    Logging {
        level = LogLevel.HEADERS
        logger = NetworkLogger
    }
}
