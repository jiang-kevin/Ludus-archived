package com.monachrom.ludus.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.monachrom.ludus.ui.song.SongViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SongViewModel::class)
    abstract fun bindSongViewModel(songViewModel: SongViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: LudusViewModelFactory): ViewModelProvider.Factory
}