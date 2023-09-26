package com.example.auth.di

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class JazzApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@JazzApplication)
            modules(appModule)
        }
    }
}