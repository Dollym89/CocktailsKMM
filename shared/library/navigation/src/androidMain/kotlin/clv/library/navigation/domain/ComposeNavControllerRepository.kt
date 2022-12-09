package clv.library.navigation.domain

import androidx.navigation.NavHostController
import clv.library.navigation.model.ComposeNavRoute

public interface ComposeNavControllerRepository {
    public fun addComposeNavHostController(
        navController: NavHostController,
        route: ComposeNavRoute,
    )

    public fun removeComposeNavHostController(route: ComposeNavRoute)

    public fun clearComposeNavHostControllers()
}
