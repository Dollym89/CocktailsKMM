package clv.library.coroutines.fixtures.domain

import clv.library.coroutines.domain.FlowUseCase
import clv.library.coroutines.domain.SuspendUseCase
import clv.library.coroutines.domain.UnitFlowUseCase
import clv.library.coroutines.domain.UnitSuspendUseCase
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.yield

public inline fun <reified I : Any, reified U : SuspendUseCase<I, Unit>> coMock(): U = coMock(Unit)
public inline fun <reified I : Any, O, reified U : SuspendUseCase<I, O>> coMock(value: O): U {
    return mockk { coEvery { this@mockk.invoke(any()) } coAnswers { yield(); value } }
}

public inline fun <reified U : UnitSuspendUseCase<Unit>> unitCoMock(): U = unitCoMock(Unit)
public inline fun <O, reified U : UnitSuspendUseCase<O>> unitCoMock(value: O): U {
    return mockk { coEvery { this@mockk.invoke() } coAnswers { yield(); value } }
}

public inline fun <reified I : Any, reified U : FlowUseCase<I, Unit>> flowMock(): U = flowMock(Unit)
public inline fun <reified I : Any, O, reified U : FlowUseCase<I, O>> flowMock(value: O): U {
    return mockk { every { this@mockk.invoke(any()) } returns flowOf(value) }
}

public inline fun <reified U : UnitFlowUseCase<Unit>> unitFlowMock(): U = unitFlowMock(Unit)
public inline fun <O, reified U : UnitFlowUseCase<O>> unitFlowMock(value: O): U {
    return mockk { every { this@mockk.invoke() } returns flowOf(value) }
}
