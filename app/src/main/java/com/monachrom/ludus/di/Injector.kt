package com.monachrom.ludus.di

import com.monachrom.ludus.LudusApplication

class Injector private constructor() {
    companion object {
        fun get(): AppComponent = LudusApplication.get().component
    }
}