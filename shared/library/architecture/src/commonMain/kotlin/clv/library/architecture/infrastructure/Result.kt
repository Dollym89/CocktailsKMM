package clv.library.architecture.infrastructure

public sealed class Result<T, Error> {

    public class Fail<T, Error>(public val error: Error) : Result<T, Error>()

    public class Success<T, Error>(public val data: T) : Result<T, Error>()

    public fun isSuccess(): Boolean {
        return this is Success
    }

    public companion object {
        public fun <T, Error> fail(error: Error): Result<T, Error> {
            return Fail(error)
        }

        public fun <T, Error> success(data: T): Result<T, Error> {
            return Success(data)
        }
    }
}

/**
 * Either success or failure, nothing is returned. Just consume result.
 * When some result is needed, use Either.transform, Either.map or Either.mapError
 * @see Result.transform
 * @see Result.map
 * @see Result.mapError
 */
public inline fun <T, Error> Result<T, Error>.either(
    success: (data: T) -> Unit,
    failure: (failReason: Error) -> Unit,
) {
    when (this) {
        is Result.Success -> success.invoke(data)
        is Result.Fail -> failure.invoke(error)
    }
}

/**
 * Transform Either to something else. Success and failure returns different object
 * than was in Either.
 */
public inline fun <T, Error, Ret> Result<T, Error>.transform(
    success: (data: T) -> Ret,
    failure: (failReason: Error) -> Ret,
): Ret {
    return when (this) {
        is Result.Success -> success.invoke(data)
        is Result.Fail -> failure.invoke(error)
    }
}

/**
 * Map one Either to another Either with different types.
 * Data and error can be completely different types, but
 * whole object from this function is always Either.
 */
public inline fun <T, Error, Ret, RetError> Result<T, Error>.map(
    success: (data: T) -> Result<Ret, RetError>,
    failure: (error: Error) -> Result<Ret, RetError>,
): Result<Ret, RetError> {
    return when (this) {
        is Result.Success -> success.invoke(data)
        is Result.Fail -> failure.invoke(error)
    }
}

/**
 * Map Either to Either with different success type. Fail stays same.
 */
public inline fun <T, Error, NewT> Result<T, Error>.mapSuccess(success: (data: T) -> NewT):
    Result<NewT, Error> {
    return when (this) {
        is Result.Success -> Result.success(success(data))
        is Result.Fail -> Result.fail(error)
    }
}

/**
 * Map Either to Either with different error type. Data stays same.
 */
public inline fun <T, Error, reified NewError> Result<T, Error>.mapError(
    failure: (error: Error) -> NewError,
):
    Result<T, NewError> {
    return when (this) {
        is Result.Success -> Result.success(data)
        is Result.Fail -> Result.fail(failure(error))
    }
}

/**
 * Only in case of success block of code runs. Failed result is ignored.
 */
public inline fun <T : Any, Error, Ret> Result<T, Error>.ifSuccess(block: (data: T) -> Ret) {
    when (this) {
        is Result.Success -> block(this.data)
        is Result.Fail -> {}
    }
}

/**
 * Only in case of failure block of code runs. Success result is ignored.
 */
public inline fun <Error, Ret> Result<Any, Error>.ifFail(block: (error: Error) -> Ret) {
    when (this) {
        is Result.Success -> {}
        is Result.Fail -> block.invoke(error)
    }
}

public inline fun <T : Any, Error> Result<T, Error>.onSuccess(block: (data: T) -> Unit):
    Result<T, Error> {
    if (this is Result.Success) {
        block(this.data)
    }
    return this
}

public inline fun <T : Any, Error> Result<T, Error>.onFail(block: (fail: Error) -> Unit):
    Result<T, Error> {
    if (this is Result.Fail) {
        block(this.error)
    }
    return this
}

public inline fun <T : Any, Error> Result<T, Error>.always(block: (Result<T, Error>) -> Unit):
    Result<T, Error> {
    block(this)
    return this
}

public inline fun <T : Any, Error, NewT : Any> Result<T, Error>.then(
    block: (T) ->
    Result<NewT, Error>,
):
    Result<NewT, Error> {
    val result = map(
        success = {
            block(it)
        },
        failure = {
            Result.fail(it)
        },
    )
    return result
}
