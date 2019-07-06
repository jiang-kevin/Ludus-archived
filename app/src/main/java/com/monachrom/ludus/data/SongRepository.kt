package com.monachrom.ludus.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SongRepository {

    val provider = MediaStoreProvider.getInstance()

    fun getSongs(): LiveData<List<Song>> {
        val songs = provider.getAllSongsFromDevice()
        val liveSongs = MutableLiveData<List<Song>>()
        liveSongs.value = songs
        return liveSongs
    }
}