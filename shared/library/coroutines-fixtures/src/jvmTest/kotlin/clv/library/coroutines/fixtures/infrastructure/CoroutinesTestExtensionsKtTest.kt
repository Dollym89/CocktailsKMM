package clv.library.coroutines.fixtures.infrastructure

import io.kotest.assertions.throwables.shouldThrowAny
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.test.runTest
import org.junit.Test

internal class CoroutinesTestExtensionsKtTest {

    @Test
    fun `lastValue of flow should return last value emitted`() {
        listOf(1, 2, 3).asFlow().lastValue() shouldBe 3
    }

    @Test
    fun `lastValue of flow should throw exception when flow is empty`() {
        shouldThrowAny {
            emptyList<Any>().asFlow().lastValue()
        }
    }

    @Test
    fun `lastValue can be nested in runTest`() = runTest {
        listOf(1).asFlow().lastValue() shouldBe 1
    }

    @Test
    fun `collectValues of flow should return all values emitted`() {
        listOf(1, 2, 3).asFlow().collectValues() shouldBe listOf(1, 2, 3)
    }

    @Test
    fun `collectValues of flow should return empty list when flow is empty`() {
        emptyList<Any>().asFlow().collectValues() shouldBe emptyList()
    }

    @Test
    fun `collectValues can be nested in runTest`() = runTest {
        listOf(1).asFlow().collectValues() shouldBe listOf(1)
    }
}
