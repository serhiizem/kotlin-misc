package org.example.objects.companion

class CassandraConfig private constructor(val contactPoints: String, val port: String) {

    companion object {
        fun defaultInstance(): CassandraConfig {
            return CassandraConfig("127.0.0.1", "9042")
        }
    }
}