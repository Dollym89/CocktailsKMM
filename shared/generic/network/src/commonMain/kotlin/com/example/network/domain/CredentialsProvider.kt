package com.example.network.domain

public interface CredentialsProvider {
    public fun username(): String
    public fun password(): String
    public fun customerId(): String
    public fun hasCredentials(): Boolean
}
