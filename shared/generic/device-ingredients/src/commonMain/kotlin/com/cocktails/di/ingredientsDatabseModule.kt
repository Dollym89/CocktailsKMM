package com.cocktails.di

import clv.library.koin.di.factoryOf
import com.cocktails.data.*
import com.cocktails.domain.IngredientsApi
import com.cocktails.domain.IngredientsRepository
import com.cocktails.domain.IngredientsUseCase
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

public val ingredientsDatabaseModule: Module = module {
    factory(named(LOCAL_REPOSITORY)) {
        IngredientsLocalRepository(get(), get())
    } bind IngredientsRepository::class

    factory(named(REMOTE_REPOSITORY)) {
        IngredientsRemoteRepository(get(), get())
    } bind IngredientsRepository::class

    factory(named(LOCAL_LOAD_INGREDIENTS)) {
        IngredientsUseCase.LoadAll(get(named(LOCAL_REPOSITORY)))
    }

    factory(named(REMOTE_LOAD_INGREDIENTS)) {
        IngredientsUseCase.LoadAll(get(named(REMOTE_REPOSITORY)))
    }

    factoryOf(::IngredientsRemoteApi) bind IngredientsApi::class
    factoryOf(::IngredientsDTORemoteConverter)
    factoryOf(::IngredientsDTOLocalConverter)
}


private const val LOCAL_LOAD_INGREDIENTS: String = "load_local"
public const val REMOTE_LOAD_INGREDIENTS: String = "remote_local"
private const val LOCAL_REPOSITORY: String = "local_repo"
public const val REMOTE_REPOSITORY: String = "remote_repo"

