package clv.library.navigation.device

import clv.library.logger.infrastructure.logD
import clv.library.navigation.domain.NavigationController
import clv.library.navigation.domain.NavigationController.Action
import clv.library.navigation.domain.NavigationController.Destination
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

internal class NavigationControllerImpl(
    private val scope: CoroutineScope,
) : NavigationController {

    private val backRequestsStream = MutableSharedFlow<Unit>()
    private val homeRequestsStream = MutableSharedFlow<Unit>()
    private val navigateRequestsStream = MutableSharedFlow<Action>()
    private val destinationStream = MutableSharedFlow<Destination>()
    private val navigationActiveStream = MutableStateFlow(false)

    override var currentDestination: Destination? = null
        private set

    override fun observeNavigationActive() = navigationActiveStream
    override fun observeDestinations() = destinationStream.onEach { logD("Destination: $it") }

    override fun navigate(action: Action) {
        logD("Navigate: $action")
        scope.launch { navigateRequestsStream.emit(action) }
    }

    override fun back() {
        logD("Back")
        scope.launch { backRequestsStream.emit(Unit) }
    }

    override fun home() {
        logD("Home")
        scope.launch { homeRequestsStream.emit(Unit) }
    }

    fun observeBackRequests() = backRequestsStream
    fun observeHomeRequests() = homeRequestsStream
    fun observeNavigateRequests() = navigateRequestsStream.onEach { logD("Action: $it") }

    fun onNavigationExecuted(destination: Destination) {
        logD("Navigation executed: $destination")
        currentDestination = destination
        scope.launch { destinationStream.emit(destination) }
    }

    fun onNavigationActive(active: Boolean) {
        logD("Navigation active: $active")
        navigationActiveStream.value = active
    }
}
