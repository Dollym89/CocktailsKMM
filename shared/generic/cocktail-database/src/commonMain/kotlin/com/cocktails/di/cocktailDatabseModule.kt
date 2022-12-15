package com.cocktails.di

import clv.library.koin.di.factoryOf
import com.cocktails.data.CocktailsLocalRepository
import com.cocktails.domain.CocktailsRepository
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

public val cocktailDatabase: Module = module {
    factoryOf(::CocktailsLocalRepository) bind CocktailsRepository::class
}
