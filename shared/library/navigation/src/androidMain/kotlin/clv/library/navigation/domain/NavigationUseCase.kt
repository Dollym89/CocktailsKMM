package clv.library.navigation.domain

import clv.library.coroutines.domain.UnitFlowUseCase
import clv.library.navigation.domain.NavigationController.Destination
import kotlinx.coroutines.flow.Flow

public sealed class NavigationUseCase {

    public class ObserveDestinations internal constructor(
        private val navigationController: NavigationController,
    ) : UnitFlowUseCase<Destination>() {
        override fun invoke(): Flow<Destination> {
            return navigationController.observeDestinations()
        }
    }

    public class ObserveNavigationActive internal constructor(
        private val navigationController: NavigationController,
    ) : UnitFlowUseCase<Boolean>() {
        override fun invoke(): Flow<Boolean> {
            return navigationController.observeNavigationActive()
        }
    }
}
