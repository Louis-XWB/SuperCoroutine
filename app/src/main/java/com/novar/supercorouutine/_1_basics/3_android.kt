package com.novar.supercorouutine._1_basics

import android.os.Bundle
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewModelScope
import com.novar.supercorouutine.R
import com.novar.supercorouutine.common.Contributor
import com.novar.supercorouutine.common.gitHub
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AndroidActivity : ComponentActivity() {
    private lateinit var infoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_1)
        infoTextView = findViewById(R.id.infoTextView)

        // KTX
        lifecycleScope.launch {

        }
        // ContinuationInterceptor
        Dispatchers.Default
        // Handler.post()
    }

    class MyViewModel : ViewModel() {
        fun someFun() {
            viewModelScope.launch {

            }
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