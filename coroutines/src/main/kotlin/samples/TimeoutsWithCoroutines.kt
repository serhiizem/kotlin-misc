package samples

import kotlinx.coroutines.*

fun timeoutWithNull() = runBlocking {
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

fun timeoutWithException() = runBlocking {
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