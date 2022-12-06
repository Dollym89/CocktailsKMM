package clv.library.navigation.system

import androidx.navigation.NavGraph
import androidx.navigation.NavInflater

/**
 * Lambda for building a [NavGraph] based on given [NavInflater].
 */
public typealias NavGraphFactory = (NavInflater) -> NavGraph
