package org.example.derivation.clients

class CorporateClient(clientId: Int, clientName: String) : Client(clientId, clientName) {
    constructor(clientId: Int, clientName: String, email: String) : this(clientId, clientName)
}

class JavaStyleCorporateClient: Client {
    constructor(clientId: Int, clientName: String): super(clientId, clientName)
    constructor(clientId: Int, clientName: String, email: String) : this(clientId, clientName)
}