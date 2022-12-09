package clv.library.navigation.model

public open class ComposeNavRoute(public open val route: String)

public sealed class Graph(public override val route: String) : ComposeNavRoute(route) {
    public object Login : Graph("login_graph")
    public object Home : Graph("login_home")
}

public sealed class SplashRoute(public override val route: String) : ComposeNavRoute(route) {
    public object Splash : SplashRoute("splash_screen")
}

public sealed class LoginRoute(public override val route: String) : ComposeNavRoute(route) {
    public object Login : LoginRoute("login_screen")
}

public sealed class HomeRoute(public override val route: String) : ComposeNavRoute(route) {
    public object Profile : HomeRoute("profile_screen")
    public object TopRated : HomeRoute("top_rated_screen")
    public object WatchList : HomeRoute("watch_list_screen")
}
