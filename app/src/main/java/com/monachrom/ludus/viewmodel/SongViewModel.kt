package com.monachrom.ludus.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.monachrom.ludus.data.Song
import com.monachrom.ludus.data.SongRepository

class SongViewModel(songRepository: SongRepository) : ViewModel() {

    val songs: LiveData<List<Song>> = songRepository.getSongs()
}
