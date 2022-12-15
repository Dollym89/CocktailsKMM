package com.cocktails.di

import com.cocktails.CocktailDatabase
import com.cocktails.databaseDriverFactory.DatabaseDriverFactory
import org.koin.core.module.Module
import org.koin.core.qualifier.named
import org.koin.dsl.module

public val storageModule: Module = module {
    factory(named(COCKTAILS_DB_DRIVER)) {
        DatabaseDriverFactory(
            CocktailDatabase.Schema,
            COCKTAILS_DB_NAME
        )
    }
    single {
        CocktailDatabase(
            get<DatabaseDriverFactory>(named(COCKTAILS_DB_DRIVER)).createDriver()
        )
    }
    factory { get<CocktailDatabase>().cocktailQueries }
}

private const val COCKTAILS_DB_DRIVER = "cocktails_db_driver"
private const val COCKTAILS_DB_NAME = "cocktails.db"
