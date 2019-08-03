package com.monachrom.ludus.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.monachrom.ludus.LudusApplication
import com.monachrom.ludus.data.SongRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        ViewModelModule::class,
        MusicModule::class]
)
interface AppComponent {

    fun viewModelFactory(): ViewModelProvider.Factory
}