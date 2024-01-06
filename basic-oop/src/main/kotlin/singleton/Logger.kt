package org.example.singleton

interface Logger {
    fun logWarn()
}

object SimpleLogger : Logger {
    override fun logWarn() {}
}