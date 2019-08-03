package com.monachrom.ludus.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.monachrom.ludus.viewmodel.LudusViewModelFactory
import com.monachrom.ludus.viewmodel.SongViewModel
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