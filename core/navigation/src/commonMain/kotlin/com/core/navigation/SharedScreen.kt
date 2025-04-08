package com.core.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider
import cafe.adriel.voyager.core.registry.ScreenRegistry
import cafe.adriel.voyager.core.screen.Screen
import com.core.domain.model.supabase.db.AudioDataItem

sealed interface SharedScreen : ScreenProvider {
    data object Splash : SharedScreen
    data object SignIn : SharedScreen
    data object SignUp : SharedScreen
    data object HomeRoute : SharedScreen
    data object NotificationsRoute : SharedScreen
    data object ContentRoute : SharedScreen
    data object TabGraphScreen : SharedScreen
    data class PlayerDetailScreen(val audioDataItem: AudioDataItem) : SharedScreen
}

fun SharedScreen.screen(): Screen = ScreenRegistry.get(this)
