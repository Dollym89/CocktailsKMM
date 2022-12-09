package clv.library.coroutines.domain

import clv.library.coroutines.infrastructure.ApplicationScope
import kotlinx.coroutines.launch

@Suppress("TooGenericExceptionCaught")
public class SwiftSuspended<out T>(private val function: suspend () -> T) {
    public fun run(handleValue: (T) -> Unit, handleError: (Throwable) -> Unit): Cancellable {
        val job = ApplicationScope.launch {
            try {
                handleValue(function())
            } catch (error: Throwable) {
                handleError(error)
            }
        }
        return object : Cancellable {
            override fun cancel() = job.cancel()
        }
    }
}
