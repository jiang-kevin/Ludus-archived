package com.monachrom.ludus.ui.song

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.monachrom.ludus.model.Song
import com.monachrom.ludus.data.SongRepository
import javax.inject.Inject

class SongViewModel @Inject constructor(songRepository: SongRepository) : ViewModel() {

    val songs: LiveData<List<Song>> = songRepository.getSongs()
}
