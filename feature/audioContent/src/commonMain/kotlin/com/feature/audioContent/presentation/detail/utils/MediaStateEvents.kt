package com.feature.audioContent.presentation.detail.utils

sealed interface MediaStateEvents {
    data object PlayPause : MediaStateEvents
    data object SeekTo : MediaStateEvents
    data object Backward : MediaStateEvents
    data object Forward : MediaStateEvents
    data object Stop : MediaStateEvents
    data class SelectedMusicChange(val url: String) : MediaStateEvents
    data class MediaProgress(val progress: Float) : MediaStateEvents
}
