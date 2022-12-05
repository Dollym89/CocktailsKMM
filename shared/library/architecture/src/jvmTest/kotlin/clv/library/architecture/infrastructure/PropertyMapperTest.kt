package clv.library.architecture.infrastructure

import clv.library.architecture.infrastructure.PropertyMapperTest.TestEnum.ONE
import clv.library.architecture.infrastructure.PropertyMapperTest.TestEnum.TWO
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.mockk.mockk
import io.mockk.verify
import kotlin.properties.Delegates
import kotlin.reflect.KProperty
import org.junit.Test

internal class PropertyMapperTest {

    @Test
    fun `mapper should map getter`() {
        val property by Delegates.observable("1", onChange()).map(intToString())

        property shouldBe 1
    }

    @Test
    @Suppress("ASSIGNED_BUT_NEVER_ACCESSED_VARIABLE", "UNUSED_VALUE")
    fun `mapper should map setter`() {
        val onChange = onChange<String>()
        var property by Delegates.observable("1", onChange).map(intToString())

        property = 2

        verify { onChange(any(), "1", "2") }
    }

    @Test
    fun `finite mapper should map all known values`() {
        val allValues = arrayOf(ONE, TWO)
        val mapper = object : FiniteValuesMapper<TestEnum, String>() {
            override fun allValues(): Array<TestEnum> = allValues
            override fun toExternal(domain: TestEnum): String = when (domain) {
                ONE -> "1"
                TWO -> "2"
            }
        }

        allValues.forEach { domain ->
            mapper.toExternal(domain).let(mapper::toDomain) shouldBe domain
        }
    }

    @Test
    fun `finite mapper should throw on unknown value`() {
        val mapper = object : FiniteValuesMapper<TestEnum, String>() {
            override fun allValues(): Array<TestEnum> = arrayOf(ONE, TWO)
            override fun toExternal(domain: TestEnum): String = when (domain) {
                ONE -> "1"
                TWO -> "2"
            }
        }

        shouldThrow<IllegalStateException> {
            mapper.toDomain("3")
        }
    }

    @Test
    fun `enum mapper should map all known values`() {
        val allValues = arrayOf(ONE, TWO)
        val mapper = enumMapper<TestEnum, String> { domain ->
            when (domain) {
                ONE -> "1"
                TWO -> "2"
            }
        }

        allValues.forEach { domain ->
            mapper.toExternal(domain).let(mapper::toDomain) shouldBe domain
        }
    }

    @Test
    fun `enum mapper should throw on unknown value`() {
        val mapper = enumMapper<TestEnum, String> { domain ->
            when (domain) {
                ONE -> "1"
                TWO -> "2"
            }
        }

        shouldThrow<IllegalStateException> {
            mapper.toDomain("3")
        }
    }

    private fun <T> onChange(): (p: KProperty<*>, old: T, new: T) -> Unit = mockk(relaxed = true)

    private fun intToString() = object : Mapper<Int, String> {
        override fun toDomain(external: String) = external.toInt()
        override fun toExternal(domain: Int) = domain.toString()
    }

    private enum class TestEnum { ONE, TWO }
}
