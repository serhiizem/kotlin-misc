package singleton

import org.amshove.kluent.invoking
import org.amshove.kluent.shouldNotThrow
import org.example.singleton.Logger
import org.example.singleton.SimpleLogger
import org.junit.jupiter.api.Test

class SimpleLoggerTest {

    @Test
    fun `should invoke methods on singleton`() {
        val logger: Logger = SimpleLogger

        invoking { logger.logWarn() } shouldNotThrow Throwable::class
    }
}