package samples

import kotlinx.coroutines.cancelAndJoin
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun printWithCancellation() = runBlocking {
    val job = launch {
        repeat(1000) {
            delay(10)
            print(".")
        }
    }

    delay(250)
    job.cancelAndJoin()
}