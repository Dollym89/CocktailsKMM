package com.example.network.domain

public interface AuthTokenApi {
    public suspend fun loadToken(username: String, password: String): String
}
