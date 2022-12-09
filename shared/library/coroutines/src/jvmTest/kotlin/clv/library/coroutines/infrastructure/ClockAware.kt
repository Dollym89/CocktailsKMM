package clv.library.coroutines.infrastructure

import io.mockk.every
import io.mockk.mockkObject
import io.mockk.unmockkObject
import kotlin.time.Duration
import kotlinx.coroutines.runBlocking
import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

internal fun clockAwareTest(block: suspend ClockAware.() -> Unit) = runBlocking {
    mockkObject(Clock.System)
    ClockAwareImpl().block()
    unmockkObject(Clock.System)
}

internal interface ClockAware {
    fun advanceTimeBy(duration: Duration)
}

private class ClockAwareImpl : ClockAware {

    private var now = Instant.DISTANT_FUTURE

    init {
        every { Clock.System.now() } answers { now }
    }

    override fun advanceTimeBy(duration: Duration) {
        now += duration
    }
}
