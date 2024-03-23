package samples.timeouts

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull
import kotlinx.coroutines.yield

fun main() = runBlocking {
    val result = withTimeoutOrNull(250) {
        repeat(1000) {
            yield()
            print('.')
            delay(10)
        }
    }

    if (result == null) {
        println("Coroutine time-out")
    }
}