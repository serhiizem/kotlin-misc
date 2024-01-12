package jvminline

import org.amshove.kluent.invoking
import org.amshove.kluent.shouldThrow
import org.example.jvminline.FinancialInstrument
import org.example.jvminline.StockExchange
import org.example.jvminline.TickerSymbol
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class FinancialInstrumentTest {

    @Test
    fun `should instantiate financial instrument`() {
        assertDoesNotThrow {
            FinancialInstrument(TickerSymbol("MSFT"), StockExchange("Nasdaq Composite"))
        }
    }

    @Test
    fun `should throw exception on invalid ticker symbol format`() {
        invoking {
            FinancialInstrument(TickerSymbol("Microsoft"), StockExchange("NASDAQ"))
        } shouldThrow IllegalArgumentException::class
    }

    @Test
    fun `should throw exception on invalid stock exchange format`() {
        invoking {
            FinancialInstrument(TickerSymbol("MSFT"), StockExchange("^Nasdaq Composite"))
        } shouldThrow IllegalArgumentException::class
    }
}