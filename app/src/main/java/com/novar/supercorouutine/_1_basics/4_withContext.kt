package com.novar.supercorouutine._1_basics

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.lifecycle.lifecycleScope
import com.novar.supercorouutine.R
import com.novar.supercorouutine.common.Contributor
import com.novar.supercorouutine.common.gitHub
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class WithContextActivity : ComponentActivity() {
    private lateinit var infoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_1)
        infoTextView = findViewById(R.id.infoTextView)


//        CoroutineScope(Dispatchers.Main).launch {
//            val data = withContext(Dispatchers.IO) {
//                // 网络代码
//                "data"
//            }
//            val processedData = withContext(Dispatchers.Default) {
//                // 处理数据
//                "processed $data"
//            }
//            println("Processed data: $processedData")
//        }

        CoroutineScope(Dispatchers.Main).launch {
            println("Test: 1 - launch ${Thread.currentThread().name}")
            withContext(Dispatchers.IO) {
                println("Test: 2 - withContext(Dispatchers.IO) ${Thread.currentThread().name}")
                Thread.sleep(2000)
            }

            println("Test: 3 - after withContext(Dispatchers.IO) ${Thread.currentThread().name}")
        }
    }

    private fun coroutinesStyle() = lifecycleScope.launch {
        val contributors = gitHub.contributors("square", "retrofit")
        showContributors(contributors)
    }

    private fun showContributors(contributors: List<Contributor>) = contributors
        .map { "${it.login} (${it.contributions})" }
        .reduce { acc, s -> "$acc\n$s" }
        .let { infoTextView.text = it }
}