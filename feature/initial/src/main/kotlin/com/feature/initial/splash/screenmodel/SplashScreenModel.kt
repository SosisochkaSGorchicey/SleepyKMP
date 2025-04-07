package com.feature.initial.splash.screenmodel

import com.core.domain.model.supabase.auth.LoggedInState
import com.core.domain.usecase.auth.IsUserLoggedInUseCase
import com.core.mvi.MviScreenModel
import com.core.mvi.emitSideEffect
import com.core.mvi.reducer
import com.feature.initial.splash.toTextRes
import kotlinx.coroutines.delay
import org.orbitmvi.orbit.syntax.simple.intent

class SplashScreenModel(
    private val isUserLoggedInUseCase: IsUserLoggedInUseCase
) : MviScreenModel<SplashState, SplashSideEffect, SplashEvent>(
    initialState = SplashState()
) {

    init {
        decideNavigation()
    }

    override fun onEvent(event: SplashEvent) {
        when (event) {
            SplashEvent.DecideNavigation -> decideNavigation()
        }
    }

    private fun decideNavigation() = intent {
        delay(750)
        isUserLoggedInUseCase().collect {
            when {
                it is LoggedInState.Error -> {
                    showError(errorTextRes = it.supabaseResult.errorType.toTextRes())
                }

                it is LoggedInState.LoggedIn -> emitSideEffect(SplashSideEffect.NavigateToHome)
                it is LoggedInState.NotLoggedIn -> emitSideEffect(SplashSideEffect.NavigateToAuth)
            }
        }
    }

    private fun showError(errorTextRes: Int) = reducer {
        state.copy(errorTextRes = errorTextRes)
    }
}