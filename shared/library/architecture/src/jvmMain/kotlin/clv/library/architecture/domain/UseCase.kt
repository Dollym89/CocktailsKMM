@file:Suppress("UnnecessaryAbstractClass")

package clv.library.architecture.domain

public actual abstract class UseCase<in I : Any, out O : Any> {
    public actual abstract operator fun invoke(input: I): O
}

public actual abstract class UnitUseCase<out O : Any> {
    public actual abstract operator fun invoke(): O
}
