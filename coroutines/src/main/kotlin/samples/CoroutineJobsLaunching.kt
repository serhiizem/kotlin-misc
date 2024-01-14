package samples

import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicInteger

const val num_tasks = 10_000
const val num_loops = 500
const val delay_ms = 10L

fun incrementWithCoroutines() = runBlocking {
    val counter = AtomicInteger()
    val jobs = mutableListOf<Job>()

    for (i in 1..num_tasks) {
        jobs.add(launch(Dispatchers.IO) {
            for (x in 1..num_loops) {
                delay(delay_ms)
            }
            counter.getAndIncrement()
        })
    }

    jobs.forEach { it.join() }
    println(counter.get())
}