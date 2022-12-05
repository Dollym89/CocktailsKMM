package clv.library.coroutines.domain

import clv.library.coroutines.infrastructure.ApplicationScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onEach

public interface Cancellable {
    public fun cancel()
}

public open class SwiftFlow<out T>(origin: Flow<T>) : Flow<T> by origin {
    public fun run(handleValue: (T) -> Unit, handleCompletion: (Throwable?) -> Unit): Cancellable {
        val job = onEach { handleValue(it) }
            .catch { handleCompletion(it) }
            .onCompletion { handleCompletion(it) }
            .launchIn(ApplicationScope)
        return object : Cancellable {
            override fun cancel() = job.cancel()
        }
    }
}

public class SwiftStateFlow<out T>(private val origin: StateFlow<T>) :
    SwiftFlow<T>(origin),
    StateFlow<T> by origin {

    override suspend fun collect(collector: FlowCollector<T>): Nothing {
        origin.collect(collector)
    }
}

public typealias CancellationException = kotlinx.coroutines.CancellationException
