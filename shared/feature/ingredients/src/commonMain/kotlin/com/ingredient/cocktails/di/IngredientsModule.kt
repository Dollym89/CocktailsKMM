package com.ingredient.cocktails.di

import com.cocktails.di.REMOTE_LOAD_INGREDIENTS
import com.ingredient.cocktails.presentation.IngredientsViewModel
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

public val ingredientsModule: Module = module {
    factory { IngredientsViewModel(get(named(REMOTE_LOAD_INGREDIENTS))) }
}
