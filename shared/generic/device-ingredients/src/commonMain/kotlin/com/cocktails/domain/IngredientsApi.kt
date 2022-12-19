package com.cocktails.domain

import com.cocktails.model.IngredientRemoteResponseDTO

public interface IngredientsApi {
    public suspend fun loadAll(): List<IngredientRemoteResponseDTO>
}
