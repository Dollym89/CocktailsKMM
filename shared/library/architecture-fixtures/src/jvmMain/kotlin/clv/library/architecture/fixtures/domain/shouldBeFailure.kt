package clv.library.architecture.fixtures.domain

import clv.library.architecture.infrastructure.Result
import clv.library.architecture.infrastructure.onFail
import clv.library.architecture.infrastructure.onSuccess
import io.kotest.assertions.collectOrThrow
import io.kotest.assertions.eq.eq
import io.kotest.assertions.errorCollector

public infix fun <T : Any, Error> Result<T, Error>.shouldBeFailure(expected: Error) {
    this.onFail {
        eq(it, expected)?.let(errorCollector::collectOrThrow)
    }.onSuccess {
        eq(this, Result.fail(expected))?.let(errorCollector::collectOrThrow)
    }
}
