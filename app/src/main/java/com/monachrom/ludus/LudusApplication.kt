package com.monachrom.ludus

import android.app.Application
import com.monachrom.ludus.data.SongRepository
import com.monachrom.ludus.di.DaggerAppComponent

class LudusApplication : Application() {

    companion object {
        var instance: LudusApplication? = null

        fun getApplicationContext(): LudusApplication {
            return instance as LudusApplication
        }
    }

    private lateinit var songRepository: SongRepository

    override fun onCreate() {
        super.onCreate()

        val component = DaggerAppComponent.builder()
            .build()

        songRepository = component.provideSongRepository()

        instance = this
    }
}