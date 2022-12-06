package clv.library.navigation.di

import clv.library.coroutines.infrastructure.ApplicationScope
import clv.library.navigation.device.NavigationControllerImpl
import clv.library.navigation.device.NavigationDispatcher
import clv.library.navigation.domain.NavigationController
import clv.library.navigation.domain.NavigationUseCase
import clv.library.navigation.system.NavigationActivityDelegate
import org.koin.core.module.Module
import org.koin.dsl.bind
import org.koin.dsl.module

public actual val navigationModule: Module = module {
    single { NavigationControllerImpl(ApplicationScope) } bind NavigationController::class
    factory { NavigationUseCase.ObserveDestinations(get()) }
    factory { NavigationUseCase.ObserveNavigationActive(get()) }
    factory { NavigationActivityDelegate(get()) }
    single { NavigationDispatcher(get()) }
}
