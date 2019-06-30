package com.monachrom.ludus.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.monachrom.ludus.data.SongRepository

class SongViewModelFactory(
    private val songRepository: SongRepository
) : ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        return SongViewModel(songRepository) as T
    }
}