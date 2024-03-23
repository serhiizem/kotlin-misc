package org.example.sealed

sealed class SealedError {

    abstract fun errorMessage(): String

    data class NetworkError(private val errorCode: Int) : SealedError() {
        override fun errorMessage(): String = "Error with code $errorCode"

        fun isSafeToProceed(): Boolean = errorCode < 100
    }

    data class DatabaseError(private val databaseErrorMessage: String) : SealedError() {
        override fun errorMessage(): String = databaseErrorMessage
    }
}