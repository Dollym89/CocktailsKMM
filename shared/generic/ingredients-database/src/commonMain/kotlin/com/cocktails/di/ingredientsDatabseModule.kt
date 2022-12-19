package com.cocktails.di

import clv.library.koin.di.factoryOf
import com.cocktails.data.IngredientsLocalRepository
import com.cocktails.domain.IngredientsRepository
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

public val ingredientsDatabaseModule: Module = module {
    factoryOf(::IngredientsLocalRepository) bind IngredientsRepository::class
}
