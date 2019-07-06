package com.monachrom.ludus.util

import com.monachrom.ludus.provider.MediaStoreProvider
import com.monachrom.ludus.data.SongRepository
import com.monachrom.ludus.viewmodel.SongViewModelFactory

object InjectorUtils {
    private fun getSongRepository(): SongRepository {
        val mediaStoreProvider = MediaStoreProvider.getInstance()
        return SongRepository(mediaStoreProvider)
    }

    fun provideSongViewModelFactory(): SongViewModelFactory {
        val repository = getSongRepository()
        return SongViewModelFactory(repository)
    }
}