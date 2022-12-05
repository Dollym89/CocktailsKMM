@file:Suppress("MethodOverloading", "ParameterListWrapping")

package clv.library.koin.di

import org.koin.core.scope.Scope

public inline fun <T> Scope.instanceOf(constructor: () -> T): T = constructor()
public inline fun <T, reified A1> Scope.instanceOf(constructor: (A1) -> T): T = constructor(get())
public inline fun <T, reified A1, reified A2> Scope.instanceOf(
    constructor: (A1, A2) -> T,
): T = constructor(get(), get())

public inline fun <T, reified A1, reified A2, reified A3> Scope.instanceOf(
    constructor: (A1, A2, A3) -> T,
): T = constructor(get(), get(), get())

public inline fun <T, reified A1, reified A2, reified A3, reified A4> Scope.instanceOf(
    constructor: (A1, A2, A3, A4) -> T,
): T = constructor(get(), get(), get(), get())

public inline fun <T, reified A1, reified A2, reified A3, reified A4, reified A5> Scope.instanceOf(
    constructor: (A1, A2, A3, A4, A5) -> T,
): T = constructor(get(), get(), get(), get(), get())

public inline fun <
    T, reified A1, reified A2, reified A3, reified A4, reified A5, reified A6,
    > Scope.instanceOf(
    constructor: (A1, A2, A3, A4, A5, A6) -> T,
): T = constructor(get(), get(), get(), get(), get(), get())

public inline fun <
    T, reified A1, reified A2, reified A3, reified A4, reified A5, reified A6, reified A7,
    > Scope.instanceOf(
    constructor: (A1, A2, A3, A4, A5, A6, A7) -> T,
): T = constructor(get(), get(), get(), get(), get(), get(), get())

public inline fun <
    T, reified A1, reified A2, reified A3, reified A4, reified A5, reified A6, reified A7,
    reified A8,
    > Scope.instanceOf(
    constructor: (A1, A2, A3, A4, A5, A6, A7, A8) -> T,
): T = constructor(get(), get(), get(), get(), get(), get(), get(), get())

public inline fun <
    T, reified A1, reified A2, reified A3, reified A4, reified A5, reified A6, reified A7,
    reified A8, reified A9,
    > Scope.instanceOf(
    constructor: (A1, A2, A3, A4, A5, A6, A7, A8, A9) -> T,
): T = constructor(get(), get(), get(), get(), get(), get(), get(), get(), get())

public inline fun <
    T, reified A1, reified A2, reified A3, reified A4, reified A5, reified A6, reified A7,
    reified A8, reified A9, reified A10,
    > Scope.instanceOf(
    constructor: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10) -> T,
): T = constructor(get(), get(), get(), get(), get(), get(), get(), get(), get(), get())

public inline fun <
    T, reified A1, reified A2, reified A3, reified A4, reified A5, reified A6, reified A7,
    reified A8, reified A9, reified A10, reified A11,
    > Scope.instanceOf(
    constructor: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11) -> T,
): T = constructor(get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get())

public inline fun <
    T, reified A1, reified A2, reified A3, reified A4, reified A5, reified A6, reified A7,
    reified A8, reified A9, reified A10, reified A11, reified A12,
    > Scope.instanceOf(
    constructor: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12) -> T,
): T = constructor(
    get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
)

public inline fun <
    T, reified A1, reified A2, reified A3, reified A4, reified A5, reified A6, reified A7,
    reified A8, reified A9, reified A10, reified A11, reified A12, reified A13,
    > Scope.instanceOf(
    constructor: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13) -> T,
): T = constructor(
    get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
)

public inline fun <
    T, reified A1, reified A2, reified A3, reified A4, reified A5, reified A6, reified A7,
    reified A8, reified A9, reified A10, reified A11, reified A12, reified A13, reified A14,
    > Scope.instanceOf(
    constructor: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14) -> T,
): T = constructor(
    get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
    get(),
)

public inline fun <
    T, reified A1, reified A2, reified A3, reified A4, reified A5, reified A6, reified A7,
    reified A8, reified A9, reified A10, reified A11, reified A12, reified A13, reified A14,
    reified A15,
    > Scope.instanceOf(
    constructor: (A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13, A14, A15) -> T,
): T = constructor(
    get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(), get(),
    get(), get(),
)
