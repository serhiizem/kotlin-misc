package org.example.derivation.clients

open class Client(val clientId: Int, val clientName: String) {
    constructor(clientId: Int, clientName: String, email: String) : this(clientId, clientName) {

    }
}