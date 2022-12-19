package com.cocktails.data

import com.cocktails.Ingredient
import com.cocktails.IngredientQueries
import com.cocktails.domain.IngredientsRepository

public class IngredientsLocalRepository(private val dao: IngredientQueries) : IngredientsRepository {
    override fun removeAll() {
        dao.removeAllIngredients()
    }

    override fun removeById(id: Long) {
        dao.removeIngredient(id)
    }

    override fun selectById(id: Long): Ingredient = dao.selectIngredientById(id).executeAsOne()

    override fun selectAll(): List<Ingredient> = dao.selectAllIngredients().executeAsList()

    override fun insert(ingredient: Ingredient) {
        dao.insertIngredientObj(ingredient)
    }
}
