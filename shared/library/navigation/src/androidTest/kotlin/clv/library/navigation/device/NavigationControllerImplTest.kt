package clv.library.navigation.device

import clv.library.coroutines.fixtures.infrastructure.collectValues
import clv.library.navigation.domain.NavigationController
import clv.library.navigation.domain.NavigationController.Destination.DestinationCompose
import clv.library.navigation.model.ComposeNavRoute
import io.kotest.matchers.collections.shouldBeEmpty
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.collections.shouldHaveSingleElement
import io.kotest.matchers.shouldBe
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.Test

internal class NavigationControllerImplTest {

    @Test
    fun `back requests should not have default value`() {
        val testScope = TestScope(UnconfinedTestDispatcher())
        NavigationControllerImpl(scope = testScope)
            .observeBackRequests()
            .collectValues(testScope)
            .shouldBeEmpty()
    }

    @Test
    fun `navigation should emit back request`() {
        val testScope = TestScope(UnconfinedTestDispatcher())
        val navigation = NavigationControllerImpl(scope = testScope)

        navigation
            .observeBackRequests()
            .collectValues(testScope) { navigation.back() }
            .shouldHaveSingleElement(Unit)
    }

    @Test
    fun `home requests should not have default value`() {
        val testScope = TestScope(UnconfinedTestDispatcher())
        NavigationControllerImpl(scope = testScope)
            .observeHomeRequests()
            .collectValues(testScope)
            .shouldBeEmpty()
    }

    @Test
    fun `navigation should emit home request`() {
        val testScope = TestScope(UnconfinedTestDispatcher())
        val navigation = NavigationControllerImpl(scope = testScope)

        navigation
            .observeHomeRequests()
            .collectValues(testScope) { navigation.home() }
            .shouldHaveSingleElement(Unit)
    }

    @Test
    fun `navigation requests should not have default value`() {
        val testScope = TestScope(UnconfinedTestDispatcher())
        NavigationControllerImpl(scope = testScope)
            .observeNavigateRequests()
            .collectValues(testScope)
            .shouldBeEmpty()
    }

    @Test
    fun `navigation should emit given action`() {
        val testScope = TestScope(UnconfinedTestDispatcher())
        val navigation = NavigationControllerImpl(scope = testScope)
        val action = anyAction()

        navigation
            .observeNavigateRequests()
            .collectValues(testScope) { navigation.navigate(action) }
            .shouldHaveSingleElement(action)
    }

    @Test
    fun `destinations should not have default value`() {
        val testScope = TestScope(UnconfinedTestDispatcher())
        NavigationControllerImpl(scope = testScope)
            .observeDestinations()
            .collectValues(testScope)
            .shouldBeEmpty()
    }

    @Test
    fun `navigation should emit given destination`() {
        val testScope = TestScope(UnconfinedTestDispatcher())
        val navigation = NavigationControllerImpl(scope = testScope)
        val destination = anyDestination()

        navigation
            .observeDestinations()
            .collectValues(testScope) { navigation.onNavigationExecuted(destination) }
            .shouldHaveSingleElement(destination)
    }

    @Test
    fun `current destination should be null by default`() {
        val testScope = TestScope(UnconfinedTestDispatcher())
        NavigationControllerImpl(scope = testScope).currentDestination shouldBe null
    }

    @Test
    fun `current destination should be last destination`() {
        val testScope = TestScope(UnconfinedTestDispatcher())
        val navigation = NavigationControllerImpl(scope = testScope)
        val destination = anyDestination()

        navigation.onNavigationExecuted(destination)

        navigation.currentDestination shouldBe destination
    }

    @Test
    fun `navigation active should be false by default`() {
        val testScope = TestScope(UnconfinedTestDispatcher())
        NavigationControllerImpl(scope = testScope)
            .observeNavigationActive()
            .collectValues(testScope)
            .shouldHaveSingleElement(false)
    }

    @Test
    fun `navigation should emit navigation active distinct until changes`() {
        val testScope = TestScope(UnconfinedTestDispatcher())
        val navigation = NavigationControllerImpl(scope = testScope)

        navigation
            .observeNavigationActive()
            .collectValues(testScope) {
                navigation.onNavigationActive(true)
                navigation.onNavigationActive(true)
                navigation.onNavigationActive(false)
                navigation.onNavigationActive(false)
                navigation.onNavigationActive(true)
            }
            .shouldContainExactly(false, true, false, true)
    }

    private fun anyAction() =
        NavigationController.Action(DestinationCompose(ComposeNavRoute("test1")))

    private fun anyDestination() = DestinationCompose(ComposeNavRoute("test1"))
}
