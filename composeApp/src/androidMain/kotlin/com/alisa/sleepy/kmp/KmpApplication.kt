package com.alisa.sleepy.kmp

import android.app.Application
import com.alisa.sleepy.kmp.di.initKoin
import com.alisa.sleepy.kmp.navigation.registryVoyagerScreens
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger

class KmpApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin().apply {
            androidLogger()
            androidContext(applicationContext)
        }
        registryVoyagerScreens()
    }
}
