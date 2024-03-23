package samples.scopes

import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

/**
 * Launch 1
 * Launch 2
 * runWithLocalScope finished
 * runWithLocalScope returned
 */
fun main() = runBlocking<Unit> {
    launch {
        runWithLocalScope()
        println("runWithLocalScope returned")
    }
}

suspend fun runWithLocalScope() {
    coroutineScope {
        launch {
            println("Launch 1")
            delay(1000)
        }
        launch {
            println("Launch 2")
            delay(2000)
        }
    }
    println("runWithLocalScope finished")
}