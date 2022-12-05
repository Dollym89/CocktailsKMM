@file:Suppress("EmptyDefaultConstructor", "UnnecessaryAbstractClass")

package clv.library.architecture.domain

public expect abstract class UseCase<in I : Any, out O : Any> constructor() {
    public abstract operator fun invoke(input: I): O
}

public expect abstract class UnitUseCase<out O : Any> constructor() {
    public abstract operator fun invoke(): O
}
