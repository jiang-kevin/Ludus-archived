package com.monachrom.ludus.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SongRepository @Inject constructor(private val provider: MediaDao) {

    fun getSongs(): LiveData<List<Song>> {
        val songs = provider.getAllSongsFromDevice()
        return MutableLiveData(songs)
    }
}