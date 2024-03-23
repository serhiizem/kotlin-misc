package samples.timeouts

import kotlinx.coroutines.*

fun main() = runBlocking {
    try {
        withTimeout(250) {
            repeat(1000) {
                yield()
                print('.')
                delay(10)
            }
        }
    } catch (ex: TimeoutCancellationException) {
        println()
        println(ex)
    }
}