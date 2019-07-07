package com.monachrom.ludus.data

import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import com.monachrom.ludus.LudusApplication

class MediaStoreDao private constructor(): MediaDao {

    companion object {
        @Volatile private var instance: MediaStoreDao? = null

        fun getInstance(): MediaStoreDao {
            return instance ?: synchronized(this) {
                instance
                    ?: MediaStoreDao().also { instance = it}
            }
        }
    }

    override fun getAllSongsFromDevice(): List<Song> {
        val songs = mutableListOf<Song>()

        val tableUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI

        val projection = arrayOf(
            MediaStore.Audio.AudioColumns.TITLE,
            MediaStore.Audio.AudioColumns.ARTIST,
            MediaStore.Audio.AudioColumns.ALBUM,
            MediaStore.MediaColumns._ID)

        val selectionClause: String? = null
        val selectionArgs: Array<String> = emptyArray()
        val orderBy = MediaStore.Audio.AudioColumns.TITLE

        val context = LudusApplication.getApplicationContext()

        val c: Cursor? = context.contentResolver.query(
            tableUri,
            projection,
            selectionClause,
            selectionArgs,
            orderBy)

        if (c != null) {
            while (c.moveToNext()) {
                val title = c.getString(0)
                val artist = c.getString(1)
                val album = c.getString(2)
                val uriStr = c.getString(3)
                val songUri = Uri.withAppendedPath(tableUri, uriStr)

                val newSong = Song(title, artist, album, artist, songUri)
                songs.add(newSong)
            }
            c.close()
        }

        return songs
    }
}