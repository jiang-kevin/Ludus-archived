package com.monachrom.ludus.data

import com.monachrom.ludus.data.Song

interface MusicDao {

    fun getAllSongsFromDevice(): List<Song>
}