package com.monachrom.ludus.util

import com.monachrom.ludus.data.SongRepository
import com.monachrom.ludus.viewmodel.SongViewModelFactory

object InjectorUtils {
    private fun getSongRepository(): SongRepository {
        return SongRepository()
    }

    fun provideSongViewModelFactory(): SongViewModelFactory {
        val repository = getSongRepository()
        return SongViewModelFactory(repository)
    }
}