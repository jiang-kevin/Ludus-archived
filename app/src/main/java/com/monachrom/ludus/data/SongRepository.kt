package com.monachrom.ludus.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.monachrom.ludus.provider.MediaProvider

class SongRepository(private val provider: MediaProvider) {

    fun getSongs(): LiveData<List<Song>> {
        val songs = provider.getAllSongsFromDevice()
        val liveSongs = MutableLiveData<List<Song>>()
        liveSongs.value = songs
        return liveSongs
    }
}