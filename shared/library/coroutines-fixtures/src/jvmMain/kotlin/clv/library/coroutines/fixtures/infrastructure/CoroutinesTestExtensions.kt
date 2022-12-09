package clv.library.coroutines.fixtures.infrastructure

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.buffer
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest

public fun <T> Flow<T>.lastValue(
    testScope: TestScope = TestScope(UnconfinedTestDispatcher()),
    block: suspend TestScope.() -> Unit = {},
): T = collectValues(testScope, block).last()

public fun <T> Flow<T>.collectValues(
    testScope: TestScope = TestScope(UnconfinedTestDispatcher()),
    block: suspend TestScope.() -> Unit = {},
): List<T> {
    val values = mutableListOf<T>()
    testScope.runTest {
        val job = launch {
            collect { value -> values.add(value) }
        }
        block()
        job.cancel()
    }
    return values.toList()
}

public fun <T> Iterable<T>.asDelayedFlow(millis: Long = 1L): Flow<T> {
    return asFlow().buffer().onEach { delay(millis) }
}

public fun <T> delayedFlowOf(vararg elements: T, millis: Long = 1L): Flow<T> {
    return elements.asFlow().buffer().onEach { delay(millis) }
}

public fun <T> flowOfNotNull(element: T?): Flow<T> = flow { element?.let { emit(it) } }
