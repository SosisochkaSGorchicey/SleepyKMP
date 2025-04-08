package com.alisa.sleepy.kmp.presentation

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.transitions.SlideTransition
import com.core.navigation.SharedScreen
import com.core.navigation.screen
import com.core.ui.theme.AppTheme

@Composable
fun App() {
    AppTheme {
        Navigator(SharedScreen.Splash.screen()) {
            SlideTransition(it)
        }
    }
}
