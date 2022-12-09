package clv.library.mvvm.presentation

import clv.library.coroutines.fixtures.infrastructure.collectValues
import io.kotest.matchers.shouldBe
import org.junit.Test

internal class StatefulViewModelTest {

    @Test
    fun `state should return initial state`() {
        val initial = state()
        val viewModel = viewModel(initial = initial)

        viewModel.state_ shouldBe initial
    }

    @Test
    fun `state should return updated state`() {
        val initial = state()
        val updated = state()
        val viewModel = viewModel(initial = initial)

        viewModel.state_ = updated

        viewModel.state_ shouldBe updated
    }

    @Test
    fun `states should emit initial state`() {
        val initial = state()

        viewModel(initial = initial)
            .states
            .collectValues()
            .let { it shouldBe listOf(initial) }
    }

    @Test
    fun `states should emit updated state`() {
        val initial = state()
        val updated = state()
        val viewModel = viewModel(initial = initial)

        viewModel
            .states
            .collectValues { viewModel.state_ = updated }
            .let { it shouldBe listOf(initial, updated) }
    }

    @Test
    fun `states should always emit last state`() {
        val initial = state()
        val updated = state()
        val viewModel = viewModel(initial = initial)

        viewModel.state_ = updated
        viewModel
            .states
            .collectValues()
            .let { it shouldBe listOf(updated) }
    }

    @Test
    fun `states should not emit same state consecutively`() {
        val state = state()
        val viewModel = viewModel(initial = state)

        viewModel
            .states
            .collectValues { viewModel.state_ = state }
            .let { it shouldBe listOf(state) }
    }

    private fun state() = object : ViewModelState {}

    private fun viewModel(
        initial: ViewModelState,
    ) = object : StatefulViewModel<ViewModelState>(initial) {
        @Suppress("VarCouldBeVal") var state_
            get() = state
            set(value) {
                state = value
            }
    }
}
