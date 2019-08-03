package com.monachrom.ludus.service

import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import com.monachrom.ludus.LudusApplication

class MediaPlayerService : MediaService {

    val mediaPlayer = MediaPlayer()

    override fun playSong(uri: Uri) {

        if (!mediaPlayer.isPlaying) {
            mediaPlayer.apply {
                val audioAttributes = AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build()

                setAudioAttributes(audioAttributes)
                setDataSource(LudusApplication.get(), uri)
                prepare()
                start()
            }
        }
    }

    override fun pauseSong() {
        if (mediaPlayer.isPlaying) {
            mediaPlayer.pause()
        }
        else {
            mediaPlayer.start()
        }
    }
}