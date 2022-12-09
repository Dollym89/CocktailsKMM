package clv.library.navigation.domain

import clv.library.coroutines.fixtures.infrastructure.collectValues
import clv.library.navigation.domain.NavigationController.Destination
import clv.library.navigation.domain.NavigationUseCase.ObserveDestinations
import clv.library.navigation.domain.NavigationUseCase.ObserveNavigationActive
import clv.library.navigation.model.ComposeNavRoute
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.asFlow
import org.junit.Test

internal class NavigationUseCaseTest {

    @Test
    fun `should emit destinations of controller`() {
        val destinations = listOf(Destination.DestinationCompose(ComposeNavRoute("test1")))
        val observeDestinations = ObserveDestinations(
            navigationController = mockk {
                every { observeDestinations() } returns destinations.asFlow()
            },
        )

        observeDestinations().collectValues() shouldBe destinations
    }

    @Test
    fun `should emit navigation active values of controller`() {
        val values = listOf(true, false, true)
        val observeNavigationActive = ObserveNavigationActive(
            navigationController = mockk {
                every { observeNavigationActive() } returns values.asFlow()
            },
        )

        observeNavigationActive().collectValues() shouldBe values
    }
}
