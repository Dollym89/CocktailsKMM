import clv.library.coroutines.domain.SwiftFlow
import clv.library.coroutines.domain.SwiftSuspended
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.onEach

public fun suspendedThrow(): SwiftSuspended<Int> = SwiftSuspended { throw DummyError() }
public fun suspendedReturn(value: Int): SwiftSuspended<Int> = SwiftSuspended { value }
public fun suspendedNever(): SwiftSuspended<Int> = SwiftSuspended { delay(Long.MAX_VALUE); 0 }

public fun flowThrow(): SwiftFlow<Int> = callbackFlow<Int> { throw DummyError() }.wrapped()
public fun flowReturn(values: List<Int>): SwiftFlow<Int> = values.asFlow().wrapped()

public fun flowNever(): SwiftFlow<Int> = callbackFlow<Int> { delay(Long.MAX_VALUE) }.wrapped()
public fun flowDelayed(values: List<Int>, delay: Long): SwiftFlow<Int> = values.asFlow()
    .onEach { delay(delay) }
    .wrapped()

private fun <T> Flow<T>.wrapped() = SwiftFlow(this)

public data class DummyClazz(val value: Int)
public interface DummyInterface
private class DummyError : Throwable()
