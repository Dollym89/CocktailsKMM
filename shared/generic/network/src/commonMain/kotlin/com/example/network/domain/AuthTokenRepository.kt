package com.example.network.domain

public interface AuthTokenRepository {
    public suspend fun loadToken(): String?
    public fun clearToken()
}
