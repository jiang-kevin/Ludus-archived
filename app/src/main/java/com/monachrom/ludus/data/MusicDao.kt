package com.monachrom.ludus.data

import com.monachrom.ludus.model.Song

interface MusicDao {

    fun getAllSongsFromDevice(): List<Song>
}