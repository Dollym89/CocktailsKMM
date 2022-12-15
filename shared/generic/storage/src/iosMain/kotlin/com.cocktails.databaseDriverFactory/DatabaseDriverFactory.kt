package com.cocktails.databaseDriverFactory

import com.squareup.sqldelight.db.SqlDriver
import com.squareup.sqldelight.drivers.native.NativeSqliteDriver

internal actual class DatabaseDriverFactory actual constructor(
    private val schema: SqlDriver.Schema,
    private val schemaName: String,
) {
    internal actual fun createDriver(): SqlDriver = NativeSqliteDriver(schema, schemaName)
}
