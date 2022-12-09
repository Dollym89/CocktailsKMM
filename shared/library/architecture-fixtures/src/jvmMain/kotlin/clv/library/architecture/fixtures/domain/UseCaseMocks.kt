package clv.library.architecture.fixtures.domain

import clv.library.architecture.domain.UnitUseCase
import clv.library.architecture.domain.UseCase
import io.mockk.every
import io.mockk.mockk

public inline fun <reified I : Any, reified U : UseCase<I, Unit>> mock(): U = mock(Unit)
public inline fun <reified I : Any, O, reified U : UseCase<I, O>> mock(value: O): U {
    return mockk { every { this@mockk.invoke(any()) } returns value }
}

public inline fun <reified U : UnitUseCase<Unit>> unitMock(): U = unitMock(Unit)
public inline fun <O, reified U : UnitUseCase<O>> unitMock(value: O): U {
    return mockk { every { this@mockk.invoke() } returns value }
}
