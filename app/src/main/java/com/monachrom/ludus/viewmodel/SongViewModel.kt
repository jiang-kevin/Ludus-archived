package com.monachrom.ludus.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.monachrom.ludus.data.Song
import com.monachrom.ludus.data.SongRepository

class SongViewModel(songRepository: SongRepository) : ViewModel() {

    val songs: LiveData<List<Song>>

    init {
        songs = loadSongs()
    }

    private fun loadSongs(): LiveData<List<Song>> {
        val songs = listOf(
            Song("Beneath the Mask", "Atlus", "Persona 5", "Atlus"),
            Song("Rivers in the Desert", "Atlus", "Persona 5", "Atlus"),
            Song("Lifelight", "Sakurai", "Super Smash Bros. Ultimate", "Nintendo"),
            Song("ASGORE", "toby fox", "Undertale", "toby fox")
        )

        val liveSongs = MutableLiveData<List<Song>>()
        liveSongs.value = songs

        return liveSongs
    }
}
