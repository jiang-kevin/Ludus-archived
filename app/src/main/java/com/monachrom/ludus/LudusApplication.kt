package com.monachrom.ludus

import android.app.Application
import com.monachrom.ludus.data.SongRepository
import com.monachrom.ludus.di.AppComponent
import com.monachrom.ludus.di.DaggerAppComponent

class LudusApplication : Application() {

    companion object {
        var instance: LudusApplication? = null

        fun get(): LudusApplication {
            return instance as LudusApplication
        }
    }

    val component: AppComponent by lazy {
        DaggerAppComponent.builder()
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}