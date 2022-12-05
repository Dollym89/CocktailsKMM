package com.example.cocktailskmm.app.system

import clv.library.logger.infrastructure.Logger
import clv.library.logger.kermit.infrastructure.KermitWriter
import clv.library.logger.koin.di.logger
import co.touchlab.kermit.StaticConfig
import com.example.cocktailskmm.app.di.registerSharedModules
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.KoinAppDeclaration

public object SharedApplication {

    public fun init(platformSpecificConfiguration: KoinAppDeclaration = {}) {
        Logger.initialize(prefix = "Cocktails: ", writer = KermitWriter(kermit()))
        startKoin {
            logger(Level.ERROR)
            registerSharedModules()
            platformSpecificConfiguration()
        }
    }
}

private fun kermit() = co.touchlab.kermit.Logger(StaticConfig())
