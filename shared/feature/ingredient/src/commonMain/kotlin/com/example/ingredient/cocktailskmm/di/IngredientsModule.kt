package com.example.ingredient.cocktailskmm.di

import clv.library.koin.di.factoryOf
import com.example.ingredient.cocktailskmm.data.IngredientsApi
import org.koin.core.module.Module
import org.koin.dsl.module

public val ingredientsModule: Module = module {
    factoryOf(::IngredientsApi)
}