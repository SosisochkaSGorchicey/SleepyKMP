package com.feature.audioContent.presentation.screenmodel

import androidx.compose.runtime.Immutable
import com.core.domain.model.supabase.db.AudioDataItem
import com.core.domain.model.supabase.db.AudioSection
import org.jetbrains.compose.resources.StringResource

@Immutable
data class AudioContentState(
    val audioContent: List<AudioSection> = emptyList(),
    val inLoading: Boolean = true,
    val errorTextRes: StringResource? = null
)

sealed interface AudioContentEvent {
    data object ReloadData : AudioContentEvent
    data class OnItemClick(val audioDataItem: AudioDataItem) : AudioContentEvent
}

sealed interface AudioContentSideEffect {
    data class NavigateToDetailScreen(val audioDataItem: AudioDataItem) : AudioContentSideEffect
}
