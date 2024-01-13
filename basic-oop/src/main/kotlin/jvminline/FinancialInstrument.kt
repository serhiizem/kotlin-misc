package org.example.jvminline

import java.util.regex.Pattern

class FinancialInstrument(val tickerSymbol: TickerSymbol, val stockExchange: StockExchange)

@JvmInline
value class TickerSymbol(private val value: String) {
    init {
        if (value.length < 3 || value.length > 6)
            throw IllegalArgumentException("Invalid ticker symbol format: $value")
    }
}

@JvmInline
value class StockExchange(private val name: String) {

    companion object {
        val namePattern: Pattern = Pattern.compile("[\\w\\s]+")
    }

    init {
        if (!namePattern.matcher(name).matches())
            throw IllegalArgumentException("Invalid stock exchange format: $name")
    }
}