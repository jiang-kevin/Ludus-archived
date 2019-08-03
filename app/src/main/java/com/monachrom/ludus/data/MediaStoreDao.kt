package com.monachrom.ludus.data

import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import com.monachrom.ludus.LudusApplication

class MediaStoreDao: MusicDao {

    override fun getAllSongsFromDevice(): List<Song> {
        val songs = mutableListOf<Song>()

        val tableUri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI

        val projection = arrayOf(
            MediaStore.Audio.AudioColumns.TITLE,
            MediaStore.Audio.AudioColumns.ARTIST,
            MediaStore.Audio.AudioColumns.ALBUM,
            MediaStore.Audio.AudioColumns.ALBUM_ID,
            MediaStore.MediaColumns._ID)

        val selectionClause: String? = null
        val selectionArgs: Array<String> = emptyArray()
        val orderBy = MediaStore.Audio.AudioColumns.TITLE

        val context = LudusApplication.get()

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
                val albumId = c.getString(3)
                val uriStr = c.getString(4)
                val songUri = Uri.withAppendedPath(tableUri, uriStr)

                val newSong = Song(title, artist, album, albumId, artist, songUri)
                songs.add(newSong)
            }
            c.close()
        }

        return songs
    }


}