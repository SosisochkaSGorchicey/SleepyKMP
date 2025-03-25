package com.core.navigation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.registry.ScreenProvider
import cafe.adriel.voyager.core.registry.ScreenRegistry
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen

sealed interface SharedScreen : ScreenProvider {

}

@Composable
fun SharedScreen.rememberScreen(): Screen = rememberScreen(this)

fun SharedScreen.screen(): Screen = ScreenRegistry.get(this)
