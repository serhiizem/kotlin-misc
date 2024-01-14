package samples

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun suspendedHelloWorld() = runBlocking {
    launch {
        delay(1000)
        println(" World")
    }

    print("Hello")
    delay(1500)
}