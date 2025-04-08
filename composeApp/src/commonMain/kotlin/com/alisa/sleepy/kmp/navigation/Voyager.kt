package com.alisa.sleepy.kmp.navigation

import cafe.adriel.voyager.core.registry.ScreenRegistry
import com.feature.initial.di.initialScreenModule

fun registryVoyagerScreens() = ScreenRegistry {
    initialScreenModule
}
