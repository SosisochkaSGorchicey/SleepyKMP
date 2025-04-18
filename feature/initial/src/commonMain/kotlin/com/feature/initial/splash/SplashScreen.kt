package com.feature.initial.splash

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
import com.core.ui.try_again_button
import com.core.ui.uiElements.ErrorSnackbar
import com.core.ui.uiElements.MainButton
import com.feature.initial.splash.content.SplashScreenContent
import com.feature.initial.splash.screenmodel.SplashEvent
import com.feature.initial.splash.screenmodel.SplashScreenModel
import com.feature.initial.splash.screenmodel.SplashSideEffect
import org.jetbrains.compose.resources.stringResource


class SplashScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = getScreenModel<SplashScreenModel>()
        val state by viewModel.state.collectAsState()

        Scaffold { padding ->
            SplashScreenContent(
                modifier = Modifier.padding(padding)
            )

            state.errorTextRes?.let {
                ErrorSnackbar(
                    modifier = Modifier.padding(padding),
                    errorTextRes = it
                ) {
                    MainButton(
                        onClick = { viewModel.onEvent(SplashEvent.DecideNavigation) },
                        text = stringResource(resource = Res.string.try_again_button)
                    )
                }
            }
        }

        viewModel.collectSideEffect { sideEffect ->
            when (sideEffect) {
                SplashSideEffect.NavigateToAuth -> navigator.replace(
                    SharedScreen.SignIn.screen()
                )

                SplashSideEffect.NavigateToHome -> navigator.replace(
                    SharedScreen.TabGraphScreen.screen()
                )
            }
        }
    }
}
