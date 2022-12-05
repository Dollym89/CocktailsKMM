package clv.library.coroutines.infrastructure

import clv.library.coroutines.fixtures.infrastructure.collectValues
import io.kotest.matchers.collections.beEmpty
import io.kotest.matchers.collections.haveSize
import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import kotlin.time.Duration.Companion.milliseconds
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.advanceTimeBy
import org.junit.Test

@ExperimentalCoroutinesApi
internal class FlowExtensionsKtTest {

    @Test
    fun `ticker should emit in initial time`() {
        ticker(initialDelayMillis = 0, delayMillis = 1000)
            .collectValues()
            .let { it should haveSize(1) }
    }

    @Test
    fun `ticker should emit in initial time and after first delay`() {
        ticker(initialDelayMillis = 42, delayMillis = 100)
            .collectValues { advanceTimeBy(50) }
            .let { it should haveSize(1) }
    }

    @Test
    fun `ticker should emit in initial time and after each delay`() {
        ticker(initialDelayMillis = 42, delayMillis = 100)
            .collectValues { advanceTimeBy(250) }
            .let { it should haveSize(3) }
    }

    @Test
    fun `ticker should emit in initial time equal to delay if not set`() {
        ticker(delayMillis = 100)
            .collectValues { advanceTimeBy(350) }
            .let { it should haveSize(3) }
    }

    @Test
    fun `throttle first should not emit on empty flow`() = runBlocking {
        emptyFlow<Unit>()
            .throttleFirst(10.milliseconds)
            .toList() should beEmpty()
    }

    @Test
    fun `throttle first should emit single flow element`() = runBlocking {
        flowOf(Unit)
            .throttleFirst(10.milliseconds)
            .toList() should haveSize(1)
    }

    @Test
    fun `throttle first should emit each flow element when out of window`() = clockAwareTest {
        flow {
            emit(Unit)
            advanceTimeBy(42.milliseconds)
            emit(Unit)
        }
            .throttleFirst(10.milliseconds)
            .toList() should haveSize(2)
    }

    @Test
    fun `throttle first should emit only first flow element of window`() = clockAwareTest {
        flow {
            emit(1)
            advanceTimeBy(5.milliseconds)
            emit(2)
            advanceTimeBy(5.milliseconds)
            emit(3)
            advanceTimeBy(1.milliseconds)
            emit(4)
        }
            .throttleFirst(10.milliseconds)
            .toList() shouldBe listOf(1, 4)
    }
}
