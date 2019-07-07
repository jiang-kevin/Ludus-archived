package com.monachrom.ludus.media

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import com.monachrom.ludus.LudusApplication

interface MediaService {

    fun playSong(uri: Uri)
    fun pauseSong()
}