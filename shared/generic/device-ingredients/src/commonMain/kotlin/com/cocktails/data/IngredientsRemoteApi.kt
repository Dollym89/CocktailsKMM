package com.cocktails.data

import com.cocktails.domain.IngredientsApi
import com.cocktails.model.IngredientRemoteResponseDTO
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

public class IngredientsRemoteApi(
    private val httpClient: HttpClient,
    private val json: Json,
) : IngredientsApi {
    public override suspend fun loadAll(): List<IngredientRemoteResponseDTO> {
        // TODO : Switch to HTTPS
        val response: HttpResponse = httpClient.get(
            urlString = "http://cocktailsguru.net/ingredient/alcoholic/all",
        ) {
            headers {
                contentType(ContentType.Application.Json)
            }
        }
        val result: String = response.body()
        return json.decodeFromString(result)
    }
}
