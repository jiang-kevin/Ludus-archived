package com.monachrom.ludus.data

import androidx.lifecycle.LiveData
import org.junit.Test
import org.junit.runner.RunWith
import com.google.common.truth.Truth.assertThat
import com.google.common.truth.Truth.assertWithMessage
import com.monachrom.ludus.model.Song
import io.mockk.*
import org.junit.After
import org.junit.Before

internal class SongRepositoryTest {

    private var mockDao = mockk<MediaStoreDao>()

    private lateinit var target: SongRepository

    @Before
    fun setUp() {
        target = SongRepository(mockDao)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun getSongs() {
        every { mockDao.getAllSongsFromDevice() } returns listOf()
        val output = target.getSongs()

        assertThat(output).isInstanceOf(LiveData::class.java)
        verify { mockDao.getAllSongsFromDevice() }
    }
}