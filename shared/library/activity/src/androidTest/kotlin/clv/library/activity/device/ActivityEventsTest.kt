package clv.library.activity.device

import clv.library.coroutines.fixtures.infrastructure.CoroutinesDispatcherRule
import clv.library.coroutines.fixtures.infrastructure.collectValues
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.mockk.mockk
import org.junit.Rule
import org.junit.Test

internal class ActivityEventsTest {

    @get:Rule
    val coroutinesRule = CoroutinesDispatcherRule()

    private val events = ActivityEvents()

    @Test
    fun `get() should emit nothing by default`() {
        events.observe().collectValues() shouldBe emptyList()
    }

    @Test
    fun `get() should emit all posted events`() {
        events
            .observe()
            .collectValues {
                events.emit(requestPermissionResult())
                events.emit(requestPermissionResult())
                events.emit(requestPermissionResult())
            } shouldHaveSize 3
    }

    @Test
    fun `get() should emit events only when subscribed`() {
        events.emit(requestPermissionResult())
        events
            .observe()
            .collectValues {
                events.emit(requestPermissionResult())
            } shouldHaveSize 1
    }

    private fun requestPermissionResult(
        requestCode: Int = 1,
        permissions: List<String> = mockk(),
        grantResults: List<Int> = mockk(),
    ) = ActivityEvent.RequestPermissionsResult(
        requestCode = requestCode,
        permissions = permissions,
        grantResults = grantResults,
    )
}
