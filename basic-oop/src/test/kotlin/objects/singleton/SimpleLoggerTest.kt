package objects.singleton

import org.amshove.kluent.invoking
import org.amshove.kluent.shouldNotThrow
import org.example.objects.singleton.Logger
import org.example.objects.singleton.SimpleLogger
import org.junit.jupiter.api.Test

class SimpleLoggerTest {

    @Test
    fun `should invoke methods on singleton`() {
        val logger: Logger = SimpleLogger

        invoking { logger.logWarn() } shouldNotThrow Throwable::class
    }
}