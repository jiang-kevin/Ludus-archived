package com.monachrom.ludus.provider

import com.monachrom.ludus.data.Song

interface MediaProvider {

    fun getAllSongsFromDevice(): List<Song>
}