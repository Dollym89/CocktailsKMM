@file:Suppress("MethodOverloading", "ParameterListWrapping")

package clv.library.koin.di

import org.koin.core.instance.InstanceFactory
import org.koin.core.module.Module

public inline fun <reified T> Module.singleOf(
    crossinline constructor: () -> T,
    createdAtStart: Boolean = false,
): Pair<Module, InstanceFactory<T>> = single(createdAtStart = createdAtStart) {
    instanceOf(constructor)
}

public inline fun <reified T : Any, reified A1> Module.singleOf(
    crossinline constructor: (A1) -> T,
    createdAtStart: Boolean = false,
): Pair<Module, InstanceFactory<T>> = single(createdAtStart = createdAtStart) {
    instanceOf(constructor)
}

public inline fun <reified T, reified A1, reified A2> Module.singleOf(
    crossinline constructor: (A1, A2) -> T,
    createdAtStart: Boolean = false,
): Pair<Module, InstanceFactory<T>> = single(createdAtStart = createdAtStart) {
    instanceOf(constructor)
}

public inline fun <reified T, reified A1, reified A2, reified A3> Module.singleOf(
    crossinline constructor: (A1, A2, A3) -> T,
    createdAtStart: Boolean = false,
): Pair<Module, InstanceFactory<T>> = single(createdAtStart = createdAtStart) {
    instanceOf(constructor)
}

public inline fun <reified T, reified A1, reified A2, reified A3, reified A4> Module.singleOf(
    crossinline constructor: (A1, A2, A3, A4) -> T,
    createdAtStart: Boolean = false,
): Pair<Module, InstanceFactory<T>> = single(createdAtStart = createdAtStart) {
    instanceOf(constructor)
}

public inline fun <
    reified T, reified A1, reified A2, reified A3, reified A4, reified A5,
    > Module.singleOf(
    crossinline constructor: (A1, A2, A3, A4, A5) -> T,
    createdAtStart: Boolean = false,
): Pair<Module, InstanceFactory<T>> = single(createdAtStart = createdAtStart) {
    instanceOf(constructor)
}

public inline fun <
    reified T, reified A1, reified A2, reified A3, reified A4, reified A5, reified A6,
    > Module.singleOf(
    crossinline constructor: (A1, A2, A3, A4, A5, A6) -> T,
    createdAtStart: Boolean = false,
): Pair<Module, InstanceFactory<T>> = single(createdAtStart = createdAtStart) {
    instanceOf(constructor)
}

public inline fun <
    reified T, reified A1, reified A2, reified A3, reified A4, reified A5, reified A6, reified A7,
    > Module.singleOf(
    crossinline constructor: (A1, A2, A3, A4, A5, A6, A7) -> T,
    createdAtStart: Boolean = false,
): Pair<Module, InstanceFactory<T>> = single(createdAtStart = createdAtStart) {
    instanceOf(constructor)
}

public inline fun <
    reified T, reified A1, reified A2, reified A3, reified A4, reified A5, reified A6, reified A7,
    reified A8,
    > Module.singleOf(
    crossinline constructor: (A1, A2, A3, A4, A5, A6, A7, A8) -> T,
    createdAtStart: Boolean = false,
): Pair<Module, InstanceFactory<T>> = single(createdAtStart = createdAtStart) {
    instanceOf(constructor)
}

public inline fun <
    reified T, reified A1, reified A2, reified A3, reified A4, reified A5, reified A6, reified A7,
    reified A8, reified A9,
    > Module.singleOf(
    crossinline constructor: (A1, A2, A3, A4, A5, A6, A7, A8, A9) -> T,
    createdAtStart: Boolean = false,
): Pair<Module, InstanceFactory<T>> = single(createdAtStart = createdAtStart) {
    instanceOf(constructor)
}

public inline fun <
    reified T, reified A1, reified A2, reified A3, reified A4, reified A5, reified A6, reified A7,
    reified A8, reified A9, reified A10,
    > Module.singleOf(
    crossinline constructor: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) -> T,
    createdAtStart: Boolean = false,
): Pair<Module, InstanceFactory<T>> = single(createdAtStart = createdAtStart) {
    instanceOf(constructor)
}

public inline fun <
    reified T, reified A1, reified A2, reified A3, reified A4, reified A5, reified A6, reified A7,
    reified A8, reified A9, reified A10, reified A11,
    > Module.singleOf(
    crossinline constructor: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) -> T,
    createdAtStart: Boolean = false,
): Pair<Module, InstanceFactory<T>> = single(createdAtStart = createdAtStart) {
    instanceOf(constructor)
}

public inline fun <
    reified T, reified A1, reified A2, reified A3, reified A4, reified A5, reified A6, reified A7,
    reified A8, reified A9, reified A10, reified A11, reified A12,
    > Module.singleOf(
    crossinline constructor: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) -> T,
    createdAtStart: Boolean = false,
): Pair<Module, InstanceFactory<T>> = single(createdAtStart = createdAtStart) {
    instanceOf(constructor)
}

public inline fun <
    reified T, reified A1, reified A2, reified A3, reified A4, reified A5, reified A6, reified A7,
    reified A8, reified A9, reified A10, reified A11, reified A12, reified A13,
    > Module.singleOf(
    crossinline constructor: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) -> T,
    createdAtStart: Boolean = false,
): Pair<Module, InstanceFactory<T>> = single(createdAtStart = createdAtStart) {
    instanceOf(constructor)
}

public inline fun <
    reified T, reified A1, reified A2, reified A3, reified A4, reified A5, reified A6, reified A7,
    reified A8, reified A9, reified A10, reified A11, reified A12, reified A13, reified A14,
    > Module.singleOf(
    crossinline constructor: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) -> T,
    createdAtStart: Boolean = false,
): Pair<Module, InstanceFactory<T>> = single(createdAtStart = createdAtStart) {
    instanceOf(constructor)
}

public inline fun <
    reified T, reified A1, reified A2, reified A3, reified A4, reified A5, reified A6, reified A7,
    reified A8, reified A9, reified A10, reified A11, reified A12, reified A13, reified A14,
    reified A15,
    > Module.singleOf(
    crossinline constructor:
        (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) -> T,
    createdAtStart: Boolean = false,
): Pair<Module, InstanceFactory<T>> = single(createdAtStart = createdAtStart) {
    instanceOf(constructor)
}
