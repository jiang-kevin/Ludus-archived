package com.monachrom.ludus.data

interface MediaProvider {

    fun getAllSongsFromDevice(): List<Song>
}