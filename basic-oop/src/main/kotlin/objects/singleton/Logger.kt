package org.example.objects.singleton

interface Logger {
    fun logWarn()
}

object SimpleLogger : Logger {
    override fun logWarn() {}
}