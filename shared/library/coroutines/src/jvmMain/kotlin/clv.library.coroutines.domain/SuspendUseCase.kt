@file:Suppress("UnnecessaryAbstractClass")

package clv.library.coroutines.domain

public actual abstract class SuspendUseCase<in I : Any, out O : Any> {
    public actual abstract suspend operator fun invoke(input: I): O
}

public actual abstract class UnitSuspendUseCase<out O : Any> {
    public actual abstract suspend operator fun invoke(): O
}
