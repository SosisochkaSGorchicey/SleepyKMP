package com.alisa.sleepy.kmp.navigation

import cafe.adriel.voyager.core.registry.ScreenRegistry
import com.alisa.sleepy.kmp.presentation.tabGraphScreen
import com.feature.audioContent.di.contentScreenModule
import com.feature.auth.di.authScreenModule
import com.feature.home.di.homeScreenModule
import com.feature.initial.di.initialScreenModule

fun registryVoyagerScreens() = ScreenRegistry {
    initialScreenModule()
    authScreenModule()
    homeScreenModule()
    tabGraphScreen()
    contentScreenModule()
}
