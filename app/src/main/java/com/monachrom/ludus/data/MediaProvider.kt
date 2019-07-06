package com.monachrom.ludus.data

import android.content.Context

interface MediaProvider {

    fun getAllSongsFromDevice(): List<Song>
}