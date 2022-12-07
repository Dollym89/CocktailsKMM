package com.example.ingredient.cocktailskmm.data

import clv.library.logger.infrastructure.logD
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

public class IngredientsApi(
    private val httpClient: HttpClient,
    private val json: Json,
) {

    private val baseUrl = ""

    public suspend fun downloadIngredients() {
        val response: HttpResponse = httpClient.get(
            urlString = baseUrl,
        ) {
            headers {
                contentType(ContentType.Application.Json)
            }
        }
        val result: String = response.body()
        logD(result)
    }
}
