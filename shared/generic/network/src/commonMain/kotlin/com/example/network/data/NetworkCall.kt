package com.example.network.data

import io.ktor.client.plugins.ResponseException
import io.ktor.http.HttpStatusCode.Companion.Forbidden
import io.ktor.http.HttpStatusCode.Companion.Unauthorized
import io.ktor.utils.io.errors.IOException
import com.example.network.model.ApiResponse
import kotlinx.serialization.SerializationException

public suspend inline fun <T : Any, R> T.networkCall(block: T.() -> R): ApiResponse<R> {
    return runCatching(block)
        .fold(
            onSuccess = { ApiResponse.Success(it) },
            onFailure = {
                println(it)
                mapToApiError(it)
            },
        )
}

@PublishedApi
internal suspend fun mapToApiError(cause: Throwable): ApiResponse.Error =
    when (cause) {
        is ResponseException ->
            when (cause.response.status.value) {
                Unauthorized.value, Forbidden.value -> ApiResponse.Error.Unauthorized
                else -> ApiResponse.Error.HttpError(cause.response.status.value, cause.message)
            }
        is IOException ->
            ApiResponse.Error.NetworkError
        is SerializationException ->
            ApiResponse.Error.SerializationError
        else -> ApiResponse.Error.NetworkError
    }
