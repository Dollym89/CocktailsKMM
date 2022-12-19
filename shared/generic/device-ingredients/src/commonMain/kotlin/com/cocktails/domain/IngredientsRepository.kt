package com.cocktails.domain

import com.cocktails.model.Ingredient
import com.example.network.model.ApiResponse

public interface IngredientsRepository {
    public suspend fun loadAll(): ApiResponse<List<Ingredient>>
    public fun insert(ingredient: Ingredient)
    public fun removeAll()
}
