package clv.library.navigation.device

import clv.library.navigation.domain.NavigationController

public class NavigationDispatcher(
    private val navigationController: NavigationController,
) {
    public fun goTo(destination: NavigationController.Destination) {
        navigationController.navigate(
            NavigationController.Action(
                destination,
            ),
        )
    }

    public fun goBack() {
        navigationController.back()
    }
}
