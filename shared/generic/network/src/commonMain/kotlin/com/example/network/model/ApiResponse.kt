package com.example.network.model

public sealed class ApiResponse<out T> {
    public data class Success<out T>(val data: T) : ApiResponse<T>()
    public sealed class Error : ApiResponse<Nothing>() {
        public data class HttpError(val code: Int? = null, val message: String? = null) : Error()
        public object NetworkError : Error()
        public object SerializationError : Error()
        public object Unauthorized : Error()
    }
}
