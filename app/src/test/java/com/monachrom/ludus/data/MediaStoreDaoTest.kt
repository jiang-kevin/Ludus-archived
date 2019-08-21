package com.monachrom.ludus.data

import android.provider.MediaStore
import android.test.ProviderTestCase2
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import android.test.mock.MockContentResolver

import org.junit.Assert.*

class MediaStoreDaoTest {

    private lateinit var mockContentResolver: MockContentResolver

    private lateinit var target: MediaStoreDao

    @Before
    fun setUp() {
        target = MediaStoreDao(mockContentResolver)
    }
}