package com.monachrom.ludus.data

import androidx.lifecycle.LiveData
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner
import com.google.common.truth.Truth.assertThat
import com.google.common.truth.Truth.assertWithMessage
import com.monachrom.ludus.model.Song

@RunWith(MockitoJUnitRunner::class)
internal class SongRepositoryTest {

    @Mock
    private lateinit var mockDao: MediaStoreDao

    @Test
    fun getSongs() {
        val repository = SongRepository(mockDao)

    }
}