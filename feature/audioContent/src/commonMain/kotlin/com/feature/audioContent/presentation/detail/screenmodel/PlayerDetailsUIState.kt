package com.feature.audioContent.presentation.detail.screenmodel

sealed interface PlayerDetailsUIState {
    data object InitialHome : PlayerDetailsUIState
    data object HomeReady : PlayerDetailsUIState
}
