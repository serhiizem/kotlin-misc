package org.example.delegation

class Stock(val persistent: Persistent) : Persistent by persistent