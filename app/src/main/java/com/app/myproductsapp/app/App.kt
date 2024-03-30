package com.app.myproductsapp.app

import android.app.Application
import com.app.crashhandler.CrashHandler

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        if (instance == null) {
            instance = this
        }
        CrashHandler(applicationContext)
    }

    companion object {
        var instance: App? = null
    }

}