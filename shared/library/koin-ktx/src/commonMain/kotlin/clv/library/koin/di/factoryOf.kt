@file:Suppress("MethodOverloading", "ParameterListWrapping")

package clv.library.koin.di

import org.koin.core.instance.InstanceFactory
import org.koin.core.module.Module

public inline fun <reified T> Module.factoryOf(
    crossinline constructor: () -> T,
): Pair<Module, InstanceFactory<T>> = factory { instanceOf(constructor) }

public inline fun <reified T, reified A1> Module.factoryOf(
    crossinline constructor: (A1) -> T,
): Pair<Module, InstanceFactory<T>> = factory { instanceOf(constructor) }

public inline fun <reified T, reified A1, reified A2> Module.factoryOf(
    crossinline constructor: (A1, A2) -> T,
): Pair<Module, InstanceFactory<T>> = factory { instanceOf(constructor) }

public inline fun <reified T, reified A1, reified A2, reified A3> Module.factoryOf(
    crossinline constructor: (A1, A2, A3) -> T,
): Pair<Module, InstanceFactory<T>> = factory { instanceOf(constructor) }

public inline fun <reified T, reified A1, reified A2, reified A3, reified A4> Module.factoryOf(
    crossinline constructor: (A1, A2, A3, A4) -> T,
): Pair<Module, InstanceFactory<T>> = factory { instanceOf(constructor) }

public inline fun <
    reified T, reified A1, reified A2, reified A3, reified A4, reified A5,
    > Module.factoryOf(
    crossinline constructor: (A1, A2, A3, A4, A5) -> T,
): Pair<Module, InstanceFactory<T>> = factory { instanceOf(constructor) }

public inline fun <
    reified T, reified A1, reified A2, reified A3, reified A4, reified A5, reified A6,
    > Module.factoryOf(
    crossinline constructor: (A1, A2, A3, A4, A5, A6) -> T,
): Pair<Module, InstanceFactory<T>> = factory { instanceOf(constructor) }

public inline fun <
    reified T, reified A1, reified A2, reified A3, reified A4, reified A5, reified A6, reified A7,
    > Module.factoryOf(
    crossinline constructor: (A1, A2, A3, A4, A5, A6, A7) -> T,
): Pair<Module, InstanceFactory<T>> = factory { instanceOf(constructor) }

public inline fun <
    reified T, reified A1, reified A2, reified A3, reified A4, reified A5, reified A6, reified A7,
    reified A8,
    > Module.factoryOf(
    crossinline constructor: (A1, A2, A3, A4, A5, A6, A7, A8) -> T,
): Pair<Module, InstanceFactory<T>> = factory { instanceOf(constructor) }

public inline fun <
    reified T, reified A1, reified A2, reified A3, reified A4, reified A5, reified A6, reified A7,
    reified A8, reified A9,
    > Module.factoryOf(
    crossinline constructor: (A1, A2, A3, A4, A5, A6, A7, A8, A9) -> T,
): Pair<Module, InstanceFactory<T>> = factory { instanceOf(constructor) }

public inline fun <
    reified T, reified A1, reified A2, reified A3, reified A4, reified A5, reified A6, reified A7,
    reified A8, reified A9, reified A10,
    > Module.factoryOf(
    crossinline constructor: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) -> T,
): Pair<Module, InstanceFactory<T>> = factory { instanceOf(constructor) }

public inline fun <
    reified T, reified A1, reified A2, reified A3, reified A4, reified A5, reified A6, reified A7,
    reified A8, reified A9, reified A10, reified A11,
    > Module.factoryOf(
    crossinline constructor: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) -> T,
): Pair<Module, InstanceFactory<T>> = factory { instanceOf(constructor) }

public inline fun <
    reified T, reified A1, reified A2, reified A3, reified A4, reified A5, reified A6, reified A7,
    reified A8, reified A9, reified A10, reified A11, reified A12,
    > Module.factoryOf(
    crossinline constructor: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) -> T,
): Pair<Module, InstanceFactory<T>> = factory { instanceOf(constructor) }

public inline fun <
    reified T, reified A1, reified A2, reified A3, reified A4, reified A5, reified A6, reified A7,
    reified A8, reified A9, reified A10, reified A11, reified A12, reified A13,
    > Module.factoryOf(
    crossinline constructor: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) -> T,
): Pair<Module, InstanceFactory<T>> = factory { instanceOf(constructor) }

public inline fun <
    reified T, reified A1, reified A2, reified A3, reified A4, reified A5, reified A6, reified A7,
    reified A8, reified A9, reified A10, reified A11, reified A12, reified A13, reified A14,
    > Module.factoryOf(
    crossinline constructor: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) -> T,
): Pair<Module, InstanceFactory<T>> = factory { instanceOf(constructor) }

public inline fun <
    reified T, reified A1, reified A2, reified A3, reified A4, reified A5, reified A6, reified A7,
    reified A8, reified A9, reified A10, reified A11, reified A12, reified A13, reified A14,
    reified A15,
    > Module.factoryOf(
    crossinline constructor:
        (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) -> T,
): Pair<Module, InstanceFactory<T>> = factory { instanceOf(constructor) }
