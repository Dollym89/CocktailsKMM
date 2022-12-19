package com.cocktails.domain

 import com.cocktails.Ingredient

public interface IngredientsRepository {
    public fun removeAll()
    public fun removeById(id: Long)
    public fun selectById(id: Long): Ingredient
    public fun selectAll(): List<Ingredient>
    public fun insert(ingredient: Ingredient)
}
