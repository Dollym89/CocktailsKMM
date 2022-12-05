package clv.library.architecture.infrastructure

public sealed class AppError {

    public object General : AppError()
    public data class Api(val error: ApiError) : AppError() {

        public enum class ApiError {
            NO_INTERNET_CONNECTION
        }
    }
}
