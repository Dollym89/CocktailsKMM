@file:Suppress("MethodOverloading", "ParameterListWrapping")

package clv.library.mvvm.di

import clv.library.koin.di.instanceOf
import clv.library.mvvm.presentation.PlatformViewModel
import org.koin.core.definition.Definition
import org.koin.core.instance.InstanceFactory
import org.koin.core.module.Module
import org.koin.core.qualifier.Qualifier

public expect inline fun <reified T : PlatformViewModel> Module.viewModel(
    qualifier: Qualifier? = null,
    noinline definition: Definition<T>,
): Pair<Module, InstanceFactory<T>>

public inline fun <reified T : PlatformViewModel> Module.viewModelOf(
    crossinline constructor: () -> T,
): Pair<Module, InstanceFactory<T>> = viewModel { instanceOf(constructor) }

public inline fun <reified T : PlatformViewModel, reified A1> Module.viewModelOf(
    crossinline constructor: (A1) -> T,
): Pair<Module, InstanceFactory<T>> = viewModel { instanceOf(constructor) }

public inline fun <reified T : PlatformViewModel, reified A1, reified A2> Module.viewModelOf(
    crossinline constructor: (A1, A2) -> T,
): Pair<Module, InstanceFactory<T>> = viewModel { instanceOf(constructor) }

public inline fun <
    reified T : PlatformViewModel, reified A1, reified A2, reified A3,
    > Module.viewModelOf(
    crossinline constructor: (A1, A2, A3) -> T,
): Pair<Module, InstanceFactory<T>> = viewModel { instanceOf(constructor) }

public inline fun <
    reified T : PlatformViewModel, reified A1, reified A2, reified A3, reified A4,
    > Module.viewModelOf(
    crossinline constructor: (A1, A2, A3, A4) -> T,
): Pair<Module, InstanceFactory<T>> = viewModel { instanceOf(constructor) }

public inline fun <
    reified T : PlatformViewModel, reified A1, reified A2, reified A3, reified A4, reified A5,
    > Module.viewModelOf(
    crossinline constructor: (A1, A2, A3, A4, A5) -> T,
): Pair<Module, InstanceFactory<T>> = viewModel { instanceOf(constructor) }

public inline fun <
    reified T : PlatformViewModel, reified A1, reified A2, reified A3, reified A4, reified A5,
    reified A6,
    > Module.viewModelOf(
    crossinline constructor: (A1, A2, A3, A4, A5, A6) -> T,
): Pair<Module, InstanceFactory<T>> = viewModel { instanceOf(constructor) }

public inline fun <
    reified T : PlatformViewModel, reified A1, reified A2, reified A3, reified A4, reified A5,
    reified A6, reified A7,
    > Module.viewModelOf(
    crossinline constructor: (A1, A2, A3, A4, A5, A6, A7) -> T,
): Pair<Module, InstanceFactory<T>> = viewModel { instanceOf(constructor) }

public inline fun <
    reified T : PlatformViewModel, reified A1, reified A2, reified A3, reified A4, reified A5,
    reified A6, reified A7, reified A8,
    > Module.viewModelOf(
    crossinline constructor: (A1, A2, A3, A4, A5, A6, A7, A8) -> T,
): Pair<Module, InstanceFactory<T>> = viewModel { instanceOf(constructor) }

public inline fun <
    reified T : PlatformViewModel, reified A1, reified A2, reified A3, reified A4, reified A5,
    reified A6, reified A7, reified A8, reified A9,
    > Module.viewModelOf(
    crossinline constructor: (A1, A2, A3, A4, A5, A6, A7, A8, A9) -> T,
): Pair<Module, InstanceFactory<T>> = viewModel { instanceOf(constructor) }

public inline fun <
    reified T : PlatformViewModel, reified A1, reified A2, reified A3, reified A4, reified A5,
    reified A6, reified A7, reified A8, reified A9, reified A10,
    > Module.viewModelOf(
    crossinline constructor: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) -> T,
): Pair<Module, InstanceFactory<T>> = viewModel { instanceOf(constructor) }

public inline fun <
    reified T : PlatformViewModel, reified A1, reified A2, reified A3, reified A4, reified A5,
    reified A6, reified A7, reified A8, reified A9, reified A10, reified A11,
    > Module.viewModelOf(
    crossinline constructor: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) -> T,
): Pair<Module, InstanceFactory<T>> = viewModel { instanceOf(constructor) }

public inline fun <
    reified T : PlatformViewModel, reified A1, reified A2, reified A3, reified A4, reified A5,
    reified A6, reified A7, reified A8, reified A9, reified A10, reified A11, reified A12,
    > Module.viewModelOf(
    crossinline constructor: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) -> T,
): Pair<Module, InstanceFactory<T>> = viewModel { instanceOf(constructor) }

public inline fun <
    reified T : PlatformViewModel, reified A1, reified A2, reified A3, reified A4, reified A5,
    reified A6, reified A7, reified A8, reified A9, reified A10, reified A11, reified A12,
    reified A13,
    > Module.viewModelOf(
    crossinline constructor: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) -> T,
): Pair<Module, InstanceFactory<T>> = viewModel { instanceOf(constructor) }

public inline fun <
    reified T : PlatformViewModel, reified A1, reified A2, reified A3, reified A4, reified A5,
    reified A6, reified A7, reified A8, reified A9, reified A10, reified A11, reified A12,
    reified A13, reified A14,
    > Module.viewModelOf(
    crossinline constructor: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) -> T,
): Pair<Module, InstanceFactory<T>> = viewModel { instanceOf(constructor) }

public inline fun <
    reified T : PlatformViewModel, reified A1, reified A2, reified A3, reified A4, reified A5,
    reified A6, reified A7, reified A8, reified A9, reified A10, reified A11, reified A12,
    reified A13, reified A14, reified A15,
    > Module.viewModelOf(
    crossinline constructor:
        (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) -> T,
): Pair<Module, InstanceFactory<T>> = viewModel { instanceOf(constructor) }
