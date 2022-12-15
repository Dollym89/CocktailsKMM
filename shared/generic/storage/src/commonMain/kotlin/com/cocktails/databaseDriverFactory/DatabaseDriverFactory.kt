package com.cocktails.databaseDriverFactory

import com.squareup.sqldelight.db.SqlDriver

internal expect class DatabaseDriverFactory(
    schema: SqlDriver.Schema,
    schemaName: String,
) {
    internal fun createDriver() : SqlDriver
}
