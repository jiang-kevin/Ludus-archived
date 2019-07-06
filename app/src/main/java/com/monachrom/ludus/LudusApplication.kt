package com.monachrom.ludus

import android.app.Application
import android.content.Context

class LudusApplication : Application() {

    companion object {
        var instance: LudusApplication? = null

        fun getApplicationContext(): LudusApplication {
            return instance as LudusApplication
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}