package com.feature.home.presentation.screenmodel

import androidx.compose.runtime.Immutable
import com.core.domain.model.supabase.db.StoryItem
import com.feature.home.model.ArticleUIModel
import org.jetbrains.compose.resources.StringResource

@Immutable
data class HomeState(
    val errorTextRes: StringResource? = null,
    val inLoading: Boolean = true,
    val stories: List<StoryItem> = List(7) { StoryItem() },
    val articles: List<ArticleUIModel> = emptyList(),
)

sealed interface HomeEvent {
    data object OnAccountClick : HomeEvent
    data object OnSettingsClick : HomeEvent
    data object RetryDataLoad : HomeEvent
}

sealed interface HomeSideEffect {
    data object NavigateToAccount : HomeSideEffect
    data object NavigateToSettings : HomeSideEffect
}
