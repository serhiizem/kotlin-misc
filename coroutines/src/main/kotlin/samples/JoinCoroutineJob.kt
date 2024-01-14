package samples

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun joinCoroutineJob() = runBlocking {
    val job = launch {
        delay(1000)
        println(" World")
    }

    print("Hello")
    job.join()
}