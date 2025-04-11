package com.feature.audioContent.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.core.mvi.collectSideEffect
import com.core.navigation.SharedScreen
import com.core.navigation.screen
import com.core.ui.Res
import com.core.ui.theme.AppTheme
import com.core.ui.try_again_button
import com.core.ui.uiElements.ErrorSnackbar
import com.core.ui.uiElements.LoadingDisplay
import com.core.ui.uiElements.MainButton
import com.core.ui.uiElements.mainScreenElements.MainBottomBar
import com.feature.audioContent.presentation.components.AudioContentScreenUI
import com.feature.audioContent.presentation.screenmodel.AudioContentEvent
import com.feature.audioContent.presentation.screenmodel.AudioContentScreenModel
import com.feature.audioContent.presentation.screenmodel.AudioContentSideEffect
import org.jetbrains.compose.resources.stringResource

object AudioContentScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = getScreenModel<AudioContentScreenModel>()
        val state by viewModel.state.collectAsState()

        Scaffold(
            bottomBar = {
                MainBottomBar()
            },
            containerColor = AppTheme.colors.lightPeachy,
            contentColor = AppTheme.colors.baseBlue
        ) { padding ->
            AudioContentScreenUI(
                firstItemModifier = Modifier.padding(top = padding.calculateTopPadding()),
                lastItemModifier = Modifier.padding(bottom = padding.calculateBottomPadding()),
                state = state,
                onEvent = viewModel::onEvent
            )

            state.errorTextRes?.let {
                ErrorSnackbar(
                    modifier = Modifier.padding(padding),
                    errorTextRes = it
                ) {
                    MainButton(
                        onClick = { viewModel.onEvent(AudioContentEvent.ReloadData) },
                        text = stringResource(resource = Res.string.try_again_button)
                    )
                }
            }

            if (state.inLoading)
                LoadingDisplay(
                    modifier = Modifier.fillMaxSize(),
                    layoutModifier = Modifier.padding(padding)
                )
        }

        viewModel.collectSideEffect {
            when (it) {
                is AudioContentSideEffect.NavigateToDetailScreen -> navigator.push(
                    SharedScreen.PlayerDetailScreen(audioDataItem = it.audioDataItem).screen()
                )
            }
        }
    }
}
