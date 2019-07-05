package com.monachrom.ludus.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SongRepository {

    fun getSongs(): LiveData<List<Song>> {
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