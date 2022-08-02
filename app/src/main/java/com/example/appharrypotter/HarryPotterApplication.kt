package com.example.appharrypotter

import android.app.Application
import com.example.appharrypotter.di.mainModules
import com.example.appharrypotter.di.retrofitModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class HarryPotterApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@HarryPotterApplication)
            androidLogger()
            modules(listOf(mainModules, retrofitModule))
        }
    }
}