@file:Suppress("UnnecessaryAbstractClass")

package clv.library.coroutines.domain

import kotlinx.coroutines.flow.Flow

public actual abstract class FlowUseCase<in I : Any, out O : Any> {
    public actual abstract operator fun invoke(input: I): Flow<O>
}

public actual abstract class UnitFlowUseCase<out O : Any> {
    public actual abstract operator fun invoke(): Flow<O>
}
