package clv.library.coroutines.infrastructure

import kotlin.time.Duration
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.datetime.Clock

public fun ticker(delayMillis: Long, initialDelayMillis: Long = delayMillis): Flow<Unit> = flow {
    delay(initialDelayMillis)
    while (true) {
        emit(Unit)
        delay(delayMillis)
    }
}

// TODO Once available, replace by: https://github.com/Kotlin/kotlinx.coroutines/issues/1446
public fun <T> Flow<T>.throttleFirst(window: Duration): Flow<T> = flow {
    var lastEmissionTime = 0L
    collect { upstream ->
        val currentTime = Clock.System.now().toEpochMilliseconds()
        val mayEmit = currentTime - lastEmissionTime > window.inWholeMilliseconds
        if (mayEmit) {
            lastEmissionTime = currentTime
            emit(upstream)
        }
    }
}
