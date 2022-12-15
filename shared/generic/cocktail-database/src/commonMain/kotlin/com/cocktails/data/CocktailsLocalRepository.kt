package com.cocktails.data

import com.cocktails.Cocktail
import com.cocktails.CocktailQueries
import com.cocktails.domain.CocktailsRepository

public class CocktailsLocalRepository(private val dao: CocktailQueries): CocktailsRepository {
    override fun removeAll() {
        dao.removeAllCocktails()
    }

    override fun removeById(id: Long) {
        dao.removeCocktail(id)
    }

    override fun selectById(id: Long): Cocktail = dao.selectCocktailById(id).executeAsOne()

    override fun selectAll(): List<Cocktail> = dao.selectAllCocktails().executeAsList()

    override fun insert(cocktail: Cocktail) {
        dao.insertCocktailObj(cocktail)
    }
}
