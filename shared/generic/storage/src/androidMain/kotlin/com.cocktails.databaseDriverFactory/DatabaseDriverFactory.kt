package com.cocktails.databaseDriverFactory

import android.app.Application
import com.squareup.sqldelight.android.AndroidSqliteDriver
import com.squareup.sqldelight.db.SqlDriver

internal actual class DatabaseDriverFactory actual constructor(
    private val schema: SqlDriver.Schema,
    private val schemaName: String,
) {
    internal actual fun createDriver(): SqlDriver =
        AndroidSqliteDriver(schema, Application(), schemaName)
}
