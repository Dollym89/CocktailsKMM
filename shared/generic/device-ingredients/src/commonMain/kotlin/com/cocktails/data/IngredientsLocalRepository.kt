package com.cocktails.data

import com.cocktails.IngredientQueries
import com.cocktails.domain.IngredientsRepository
import com.cocktails.model.Ingredient
import com.example.network.model.ApiResponse

public class IngredientsLocalRepository(
    private val dao: IngredientQueries,
    private val ingredientsDTOLocalConverter: IngredientsDTOLocalConverter
) : IngredientsRepository {

    override fun removeAll() {
        dao.removeAllIngredients()
    }

    // TODO: Get rid of ApiResponse and Handle loadAll result
    override suspend fun loadAll(): ApiResponse<List<Ingredient>> {
        return ApiResponse.Success(
            data = dao.selectAllIngredients().executeAsList()
                .map(ingredientsDTOLocalConverter::toDomain)
        )
    }

    override fun insert(ingredient: Ingredient) {
        dao.insertIngredientExObj(ingredientsDTOLocalConverter.toExternal(ingredient))
    }
}
