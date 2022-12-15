package com.cocktails.domain

import com.cocktails.Cocktail

public interface CocktailsRepository {
    public fun removeAll()
    public fun removeById(id: Long)
    public fun selectById(id: Long): Cocktail
    public fun selectAll(): List<Cocktail>
    public fun insert(cocktail: Cocktail)
}
