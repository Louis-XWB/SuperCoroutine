package com.novar.supercorouutine

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.novar.supercorouutine.ui.theme.CourseCoroutinesTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.concurrent.Executors
import kotlin.concurrent.thread
import kotlin.coroutines.EmptyCoroutineContext

class LaunchCoroutinesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()// Enable edge-to-edge display
        setContent {
            CourseCoroutinesTheme {

            }
        }

        println("Main thread: ${Thread.currentThread().name}")


        // launch a new thread
        thread {

        }

        // launch a new thread with executor
        val executor = Executors.newCachedThreadPool()
        executor.execute {
            println("Executor thread: ${Thread.currentThread().name}")
        }

        //switch to the main thread
        // handler
        var handle = Handler(Looper.getMainLooper())
        handle.post {

        }

        // view
        val view: View = View(this)
        view.post {

        }

        //CoroutineScope
        val coroutineScope = CoroutineScope(EmptyCoroutineContext)
        coroutineScope.launch {
            println("Coroutine thread: ${Thread.currentThread().name}")
        }

        coroutineScope.launch(Dispatchers.IO) {
            println("Coroutine thread: ${Thread.currentThread().name}")
        }

    }
}