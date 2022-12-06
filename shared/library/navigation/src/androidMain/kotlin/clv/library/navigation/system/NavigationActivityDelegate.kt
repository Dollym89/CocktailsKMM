package clv.library.navigation.system

import android.content.Intent
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import clv.library.logger.infrastructure.logD
import clv.library.navigation.device.NavigationControllerImpl
import clv.library.navigation.domain.ComposeNavControllerRepository
import clv.library.navigation.domain.NavigationController
import clv.library.navigation.domain.NavigationController.Destination
import clv.library.navigation.model.ComposeNavRoute
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

public class NavigationActivityDelegate internal constructor(
    private val navigation: NavigationControllerImpl,
) : ComposeNavControllerRepository {
    private var observeNavigateRequestsJob: Job? = null
    private var observeBackRequestsJob: Job? = null
    private var observeHomeRequestsJob: Job? = null
    private var systemNavigationListener: NavController.OnDestinationChangedListener? = null

    public var fragmentNavController: NavController? = null
    private val composeNavControllers: MutableMap<ComposeNavRoute, NavHostController> =
        mutableMapOf()

    public fun registerComposeNavHostController(
        navController: NavHostController,
        route: ComposeNavRoute,
    ) {
        composeNavControllers[route] = navController
    }

    override fun addComposeNavHostController(
        navController: NavHostController,
        route: ComposeNavRoute,
    ) {
        composeNavControllers[route] = navController
    }

    override fun removeComposeNavHostController(route: ComposeNavRoute) {
        composeNavControllers.remove(route)
    }

    override fun clearComposeNavHostControllers() {
        composeNavControllers.clear()
    }

    @Suppress("LongMethod")
    public fun onStart(activity: ComponentActivity) {
        logD("Bind navigation delegate")

        NavController.OnDestinationChangedListener { _, destination, _ ->
//            logD(controller.backStackString(debugLogEnabled))
            activity.lifecycleScope.launch {
                navigation.onNavigationExecuted(Destination.DestinationFragment(destination.id))
            }
        }.let {
            systemNavigationListener = it
            fragmentNavController?.addOnDestinationChangedListener(it)
        }

        observeNavigateRequestsJob?.cancel()
        observeNavigateRequestsJob = activity.lifecycleScope.launch {
            navigation.observeNavigateRequests().collect { action ->
                when (action.destination) {
                    is Destination.DestinationCompose -> with(action.destination) {
                        composeNavControllers.values.forEach { navController ->
                            navController.findDestination(dest.route)?.let {
                                logD("${dest.route} FOUND")
                                navController.navigate(
                                    route = dest.route,
                                    navOptions = options?.build(),
                                )
                            } ?: run {
                                logD("${dest.route} NOT FOUND")
                            }
                        }
                    }
                    is Destination.DestinationFragment -> fragmentNavController?.navigate(
                        action.destination.dest,
                        null,
                        action.navOptions(),
                    )
                    is Destination.DestinationActivity<*> -> activity.startActivity(
                        Intent(activity, action.destination.dest).apply {
                            flags = action.destination.args?.flags ?: 0
                        },
                    )
                }
            }
        }

        observeBackRequestsJob?.cancel()
        observeBackRequestsJob = activity.lifecycleScope.launch {
            navigation.observeBackRequests().collect {

                fragmentNavController?.popBackStack()

                composeNavControllers.values.forEach { navController ->
                    logD("On Back")
                    navController.popBackStack()
                }
            }
        }

        observeHomeRequestsJob?.cancel()
        observeHomeRequestsJob = activity.lifecycleScope.launch {
            navigation.observeHomeRequests().collect {
                activity.moveTaskToBack(true)
            }
        }

        navigation.onNavigationActive(true)
    }

    public fun onStop() {
        logD("Unbind navigation delegate")

        navigation.onNavigationActive(false)

        observeHomeRequestsJob?.cancel()
        observeHomeRequestsJob = null

        observeBackRequestsJob?.cancel()
        observeBackRequestsJob = null

        observeNavigateRequestsJob?.cancel()
        observeNavigateRequestsJob = null

        systemNavigationListener?.let {
            fragmentNavController?.removeOnDestinationChangedListener(it)
        }
        systemNavigationListener = null
    }

    private fun NavigationController.Action.navOptions(): NavOptions? =
        when (destination) {
            is Destination.DestinationFragment -> popUpTo?.let {
                NavOptions.Builder().setPopUpTo(destination.dest, false).build()
            }
            else -> null
        }
}
