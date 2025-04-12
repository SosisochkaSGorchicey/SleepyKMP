package com.feature.audioContent.presentation.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.core.domain.model.supabase.db.AudioDataItem
import com.core.mvi.collectSideEffect
import com.feature.audioContent.presentation.detail.components.DetailsScreenUI
import com.feature.audioContent.presentation.detail.screenmodel.PlayerDetailsEvent
import com.feature.audioContent.presentation.detail.screenmodel.PlayerDetailsScreenModel
import com.feature.audioContent.presentation.detail.screenmodel.PlayerDetailsSideEffect

class DetailsScreen(
    private val imageRes: String,
    private val audioUrl: String,
    private val name: String,
    private val tag: String,
    private val minutesDuration: Int,
) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = getScreenModel<PlayerDetailsScreenModel>()
        val state by viewModel.state.collectAsState()

        LaunchedEffect(key1 = Unit) {
            viewModel.onEvent(
                PlayerDetailsEvent.InitCurrentAudio(
                    audioDataItem = AudioDataItem(
                        imageRes = imageRes,
                        audioUrl = audioUrl,
                        minutesDuration = minutesDuration,
                        name = name,
                        tag = tag
                    )
                )
            )
        }

        DetailsScreenUI(
            state = state,
            onEvent = viewModel::onEvent
        )

        viewModel.collectSideEffect { sideEffect ->
            when (sideEffect) {
                PlayerDetailsSideEffect.NavigateBack -> navigator.pop()
            }
        }
    }
}
