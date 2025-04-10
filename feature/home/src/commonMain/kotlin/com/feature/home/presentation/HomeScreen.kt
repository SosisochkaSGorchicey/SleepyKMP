package com.feature.home.presentation

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
import com.core.ui.Res
import com.core.ui.theme.AppTheme
import com.core.ui.try_again_button
import com.core.ui.uiElements.ErrorSnackbar
import com.core.ui.uiElements.LoadingDisplay
import com.core.ui.uiElements.MainButton
import com.core.ui.uiElements.mainScreenElements.AccountIcon
import com.core.ui.uiElements.mainScreenElements.MainBottomBar
import com.core.ui.uiElements.mainScreenElements.MainTopBar
import com.core.ui.uiElements.mainScreenElements.SettingsIcon
import com.feature.home.presentation.components.HomeScreenUI
import com.feature.home.presentation.screenmodel.HomeEvent
import com.feature.home.presentation.screenmodel.HomeScreenModel
import com.feature.home.presentation.screenmodel.HomeSideEffect
import org.jetbrains.compose.resources.stringResource

object HomeScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = getScreenModel<HomeScreenModel>()
        val state by viewModel.state.collectAsState()

        Scaffold(
            containerColor = AppTheme.colors.baseBlueLight,
            bottomBar = {
                MainBottomBar()
            },
            topBar = {
                MainTopBar(
                    titleText = "Hello, Alice!", //todo
                    navigationIcon = {
                        SettingsIcon(onClick = { viewModel.onEvent(HomeEvent.OnSettingsClick) })
                    },
                    actions = {
                        AccountIcon(onClick = { viewModel.onEvent(HomeEvent.OnAccountClick) })
                    }
                )
            }
        ) { padding ->
            HomeScreenUI(
                firstPaddings = Modifier.padding(top = padding.calculateTopPadding()),
                lastPaddings = Modifier.padding(bottom = padding.calculateBottomPadding()),
                state = state
            )

            state.errorTextRes?.let {
                ErrorSnackbar(
                    modifier = Modifier.padding(padding),
                    errorTextRes = it
                ) {
                    MainButton(
                        onClick = { viewModel.onEvent(HomeEvent.RetryDataLoad) },
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
                HomeSideEffect.NavigateToAccount -> {} //todo
                HomeSideEffect.NavigateToSettings -> {} //todo
            }
        }
    }
}
