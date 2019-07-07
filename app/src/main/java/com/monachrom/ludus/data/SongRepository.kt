package com.monachrom.ludus.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SongRepository(private val provider: MediaDao) {

    fun getSongs(): LiveData<List<Song>> {
        val songs = provider.getAllSongsFromDevice()
        val liveSongs = MutableLiveData<List<Song>>()
        liveSongs.value = songs
        return liveSongs
    }
}