package com.monachrom.ludus.data

import android.database.Cursor
import android.provider.MediaStore
import com.monachrom.ludus.LudusApplication

class MediaStoreProvider private constructor(): MediaProvider {

    companion object {
        @Volatile private var instance: MediaStoreProvider? = null

        fun getInstance(): MediaStoreProvider {
            return instance ?: synchronized(this) {
                instance ?: MediaStoreProvider().also {instance = it}
            }
        }
    }

    override fun getAllSongsFromDevice(): List<Song> {
        val songs = mutableListOf<Song>()

        val uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI
        val proj = arrayOf(
            MediaStore.Audio.AudioColumns.TITLE,
            MediaStore.Audio.AudioColumns.ARTIST,
            MediaStore.Audio.AudioColumns.ALBUM)

        val context = LudusApplication.getApplicationContext()

        val c: Cursor? = context.contentResolver.query(
            uri,
            proj,
            null,
            null,
            null)

        if (c != null) {
            while (c.moveToNext()) {
                val title = c.getString(0)
                val artist = c.getString(1)
                val album = c.getString(2)

                val newSong = Song(title, artist, album, artist)
                songs.add(newSong)
            }
            c.close()
        }

        return songs
    }
}