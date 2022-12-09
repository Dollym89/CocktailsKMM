package clv.library.logger.koin.di

import clv.library.logger.infrastructure.logD
import clv.library.logger.infrastructure.logE
import clv.library.logger.infrastructure.logI
import org.koin.core.KoinApplication
import org.koin.core.logger.Level
import org.koin.core.logger.Logger
import org.koin.core.logger.MESSAGE

public fun KoinApplication.logger(level: Level = Level.INFO): KoinApplication {
    return logger(KoinLogger(level))
}

private class KoinLogger(level: Level) : Logger(level) {
    override fun log(level: Level, msg: MESSAGE) = when (level) {
        Level.DEBUG -> logD(msg)
        Level.INFO -> logI(msg)
        Level.ERROR -> logE(msg)
        Level.NONE -> Unit
    }
}
