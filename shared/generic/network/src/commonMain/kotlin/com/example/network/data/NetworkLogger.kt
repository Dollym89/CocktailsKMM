package com.example.network.data

import clv.library.logger.infrastructure.logD
import clv.library.logger.infrastructure.logV
import io.ktor.client.plugins.logging.*

/** A Ktor [Logger] logs on DEBUG level, but potentially extensive bodies on VERBOSE level. */
internal object NetworkLogger : Logger {

    override fun log(message: String) {
        if (message.isInfo()) {
            logD(message)
        } else {
            logV(prettyPrint(message))
        }
    }

    private fun String.isInfo() = takeWhile { it != ':' } in setOf("REQUEST", "RESPONSE", "FROM")
    private fun String.isJson() = startsWith("{") && endsWith("}")
    private fun String.isArray() = startsWith("[") && endsWith("]")
    private fun prettyPrint(message: String): String {
        return if (!message.isJson() && !message.isArray()) {
            message
        } else {
            message
                .map(NetworkLogger::decorate)
                .joinToString(separator = "")
        }
    }

    private fun decorate(char: Char) = when (char) {
        in setOf('{', '[', ',') -> "$char\n"
        in setOf('}', ']') -> "\n$char"
        else -> "$char"
    }
}
