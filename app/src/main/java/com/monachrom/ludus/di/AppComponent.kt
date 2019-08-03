package com.monachrom.ludus.di

import com.monachrom.ludus.data.SongRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        MusicModule::class]
)
interface AppComponent {

    fun provideSongRepository(): SongRepository
}