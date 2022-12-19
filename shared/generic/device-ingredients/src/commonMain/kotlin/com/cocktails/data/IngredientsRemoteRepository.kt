package com.cocktails.data

import com.cocktails.domain.IngredientsApi
import com.cocktails.domain.IngredientsRepository
import com.cocktails.model.Ingredient
import com.example.network.data.networkCall
import com.example.network.model.ApiResponse
import com.example.network.model.ApiResponse.Success

public class IngredientsRemoteRepository(
    private val ingredientsRemoteApi: IngredientsApi,
    private val ingredientsDTOConverter: IngredientsDTORemoteConverter,
) : IngredientsRepository {
    override suspend fun loadAll(): ApiResponse<List<Ingredient>> {
        networkCall {
            ingredientsRemoteApi.loadAll()
        }.run {
            return when (this) {
                is Success -> Success(data.map(ingredientsDTOConverter::toDomain))
                else -> this as ApiResponse.Error
            }
        }
    }

    override fun insert(ingredient: Ingredient) {
        // TODO: Implement in the future when user custom cocktails are available
    }

    override fun removeAll() {
        // TODO: Implement in the future when user custom cocktails are available
    }
}
