package com.monachrom.ludus.ui.song

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.monachrom.ludus.data.SongRepository
import com.monachrom.ludus.model.Song
import io.mockk.clearAllMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class SongViewModelTest {

    private val mockSongRepository = mockk<SongRepository>()

    private lateinit var target: SongViewModel

    @Before
    fun setUp() {
        every { mockSongRepository.getSongs() } returns MutableLiveData<List<Song>>() as LiveData<List<Song>>
        target = SongViewModel(mockSongRepository)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun getSongs() {

        verify { mockSongRepository.getSongs() }
    }
}