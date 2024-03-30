package com.app.crashhandler

import android.os.Bundle
import android.widget.TextView
import androidx.activity.addCallback
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class CrashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_crash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val stackString = intent.getStringExtra(CrashHandler.STACK_TRACE) ?: "No stacktrace received!!"
        val stackStringMessage = intent.getStringExtra(CrashHandler.STACK_TRACE_MESSAGE) ?: "No stacktrace message received!!"
        val logCat = findViewById<TextView>(R.id.logcat)
        val cause = findViewById<TextView>(R.id.cause)
        logCat.text = stackString
        cause.text = stackStringMessage
        onBackPressedDispatcher.addCallback {
            finishAffinity()
        }
    }
}