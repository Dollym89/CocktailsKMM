package com.example.cocktailskmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform