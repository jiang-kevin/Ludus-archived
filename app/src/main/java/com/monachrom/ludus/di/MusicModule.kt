package com.monachrom.ludus.di

import com.monachrom.ludus.data.MediaDao
import com.monachrom.ludus.data.MediaStoreDao
import com.monachrom.ludus.data.SongRepository
import dagger.Module
import dagger.Provides

@Module
class MusicModule {

    @Provides
    fun mediaDao(): MediaDao {
        return MediaStoreDao.getInstance()
    }

    @Provides
    fun songRepository(mediaDao: MediaDao): SongRepository {
        return SongRepository(mediaDao)
    }

}