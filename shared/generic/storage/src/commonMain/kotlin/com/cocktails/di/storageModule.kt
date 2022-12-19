package com.cocktails.di

import com.cocktails.IngredientsDatabase
import com.cocktails.databaseDriverFactory.DatabaseDriverFactory
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

public val storageModule: Module = module {
    factory(named(INGREDIENTS_DB_DRIVER)) {
        DatabaseDriverFactory(
            IngredientsDatabase.Schema,
            INGREDIENTS_DB_NAME
        )
    }
    single {
        IngredientsDatabase(
            get<DatabaseDriverFactory>(named(INGREDIENTS_DB_NAME)).createDriver()
        )
    }
    factory { get<IngredientsDatabase>().ingredientQueries }
}

private const val INGREDIENTS_DB_DRIVER = "ingredients_db_driver"
private const val INGREDIENTS_DB_NAME = "ingredients.db"
