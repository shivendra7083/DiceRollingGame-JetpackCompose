package org.example.mydicegame

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform