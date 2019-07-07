package com.monachrom.ludus.media

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import com.monachrom.ludus.LudusApplication

class MediaPlayerService : MediaService {

    val mediaPlayer = MediaPlayer()

    override fun playSong(uri: Uri) {
        mediaPlayer.apply {
            val audioAttributes = AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_MEDIA)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build()

            setAudioAttributes(audioAttributes)
            setDataSource(LudusApplication.getApplicationContext(), uri)
            prepare()
            start()
        }
    }
}