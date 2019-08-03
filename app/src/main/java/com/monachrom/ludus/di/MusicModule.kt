package com.monachrom.ludus.di

import com.monachrom.ludus.data.MusicDao
import com.monachrom.ludus.data.MediaStoreDao
import dagger.Module
import dagger.Provides

@Module
class MusicModule {

    @Provides
    fun mediaDao(): MusicDao {
        return MediaStoreDao()
    }
}