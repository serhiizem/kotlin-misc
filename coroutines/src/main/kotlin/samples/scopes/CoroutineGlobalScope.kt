package samples.scopes

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Launch 1
 * runWithGlobalScope finished
 * runWithGlobalScope returned
 * Launch 2
 */
fun main() = runBlocking<Unit> {
    launch {
        runWithGlobalScope()
        println("runWithGlobalScope returned")
    }
}

suspend fun runWithGlobalScope() {
    GlobalScope.launch {
        println("Launch 1")
        delay(1000)
    }
    GlobalScope.launch {
        println("Launch 2")
        delay(2000)
    }
    println("runWithGlobalScope finished")
}
