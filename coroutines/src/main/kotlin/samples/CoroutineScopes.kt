package samples

import kotlinx.coroutines.*

/**
 * Launch 1
 * Launch 2
 * runWithLocalScope finished
 * runWithLocalScope returned
 */
fun launchWorkInLocalScope() = runBlocking<Unit> {
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

/**
 * Launch 1
 * runWithGlobalScope finished
 * runWithGlobalScope returned
 * Launch 2
 */
fun launchWorkInGlobalScope() = runBlocking<Unit> {
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
