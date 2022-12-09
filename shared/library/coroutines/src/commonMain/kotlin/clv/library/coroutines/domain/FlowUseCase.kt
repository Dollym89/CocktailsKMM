@file:Suppress("EmptyDefaultConstructor", "UnnecessaryAbstractClass")

package clv.library.coroutines.domain

import kotlinx.coroutines.flow.Flow

public expect abstract class FlowUseCase<in I : Any, out O : Any> constructor() {
    public abstract operator fun invoke(input: I): Flow<O>
}

public expect abstract class UnitFlowUseCase<out O : Any> constructor() {
    public abstract operator fun invoke(): Flow<O>
}
