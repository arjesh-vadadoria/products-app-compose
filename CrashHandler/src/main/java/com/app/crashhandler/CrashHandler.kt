package com.app.crashhandler

import android.content.Context
import android.content.Intent
import kotlin.system.exitProcess


class CrashHandler(private val context: Context) : Thread.UncaughtExceptionHandler {
    init {
        Thread.setDefaultUncaughtExceptionHandler(this)
    }

    private val defaultHandler: Thread.UncaughtExceptionHandler? = Thread.getDefaultUncaughtExceptionHandler()

    override fun uncaughtException(t: Thread, e: Throwable) {
        try {
            val intent = Intent(context, CrashActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_TASK_ON_HOME or
                        Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS or Intent.FLAG_ACTIVITY_NO_HISTORY
                putExtra(STACK_TRACE, e.stackTraceToString())
                putExtra(STACK_TRACE_MESSAGE, e.message)
            }
            context.startActivity(intent)
            android.os.Process.killProcess(android.os.Process.myPid())
            exitProcess(0)
        } catch (e: Exception) {
            this.defaultHandler?.uncaughtException(t, e)
        }
    }

    companion object {
        const val STACK_TRACE = "stack_trace"
        const val STACK_TRACE_MESSAGE = "stack_trace_message"
    }
}