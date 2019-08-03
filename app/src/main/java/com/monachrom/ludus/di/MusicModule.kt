package com.monachrom.ludus.di

import com.monachrom.ludus.data.MusicDao
import com.monachrom.ludus.data.MediaStoreDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MusicModule {

    @Provides
    @Singleton
    fun mediaDao(): MusicDao {
        return MediaStoreDao()
    }
}