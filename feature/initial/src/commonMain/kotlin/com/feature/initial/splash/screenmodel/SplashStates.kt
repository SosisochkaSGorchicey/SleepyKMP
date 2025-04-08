package com.feature.initial.splash.screenmodel

import androidx.compose.runtime.Immutable
import org.jetbrains.compose.resources.StringResource

@Immutable
data class SplashState(
    val errorTextRes: StringResource? = null
)

sealed interface SplashEvent {
    data object DecideNavigation : SplashEvent
}

sealed interface SplashSideEffect {
    data object NavigateToAuth : SplashSideEffect
    data object NavigateToHome : SplashSideEffect
}
