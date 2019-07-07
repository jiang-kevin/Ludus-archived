package com.monachrom.ludus.data

import com.monachrom.ludus.data.Song

interface MediaDao {

    fun getAllSongsFromDevice(): List<Song>
}