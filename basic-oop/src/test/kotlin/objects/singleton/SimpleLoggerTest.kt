package objects.singleton

import org.example.objects.singleton.Logger
import org.example.objects.singleton.SimpleLogger
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

class SimpleLoggerTest {

    @Test
    fun `should invoke methods on singleton`() {
        val logger: Logger = SimpleLogger

        assertDoesNotThrow { logger.logWarn() }
    }
}