@file:Suppress("EmptyDefaultConstructor", "UnnecessaryAbstractClass")

package clv.library.coroutines.domain

public expect abstract class SuspendUseCase<in I : Any, out O : Any> constructor() {
    public abstract suspend operator fun invoke(input: I): O
}

public expect abstract class UnitSuspendUseCase<out O : Any> constructor() {
    public abstract suspend operator fun invoke(): O
}
