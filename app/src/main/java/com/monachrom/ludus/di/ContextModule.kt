package com.monachrom.ludus.di

import android.content.ContentResolver
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ContextModule(private val appContext: Context) {

    @Provides
    fun appContext(): Context = appContext

    @Provides
    fun contentResolver(): ContentResolver {
        return appContext.contentResolver
    }
}