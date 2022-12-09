package clv.library.navigation.domain

import android.app.Activity
import android.content.Intent
import androidx.navigation.NavOptions
import clv.library.navigation.model.ComposeNavRoute
import kotlinx.coroutines.flow.Flow

public interface NavigationController {

    public val currentDestination: Destination?

    public fun observeNavigationActive(): Flow<Boolean>
    public fun observeDestinations(): Flow<Destination>

    public fun navigate(action: Action)
    public fun back()
    public fun home()

    public data class Action(val destination: Destination, val popUpTo: Destination? = null)

    public sealed interface Destination {
        public data class DestinationActivity<T : Activity>(
            val dest: Class<T>,
            val args: Intent? = null,
        ) : Destination

        public data class DestinationFragment(val dest: Int) : Destination
        public data class DestinationCompose(
            val dest: ComposeNavRoute,
            val options: NavOptions.Builder? = null,
        ) : Destination
    }
}
