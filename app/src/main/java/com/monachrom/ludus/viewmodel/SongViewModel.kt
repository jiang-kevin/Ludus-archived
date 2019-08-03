package com.monachrom.ludus.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.monachrom.ludus.data.Song
import com.monachrom.ludus.data.SongRepository
import javax.inject.Inject

class SongViewModel @Inject constructor(songRepository: SongRepository) : ViewModel() {

    val songs: LiveData<List<Song>> = songRepository.getSongs()
}
