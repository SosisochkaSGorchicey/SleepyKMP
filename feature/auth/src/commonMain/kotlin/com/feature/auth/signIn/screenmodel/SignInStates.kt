package com.feature.auth.signIn.screenmodel

import androidx.compose.runtime.Immutable
import org.jetbrains.compose.resources.StringResource

@Immutable
data class SignInState(
    val logInData: SignInData = SignInData(),
    val errorTextRes: StringResource? = null,
    val inLoading: Boolean = false
)

@Immutable
data class SignInData(
    val email: Pair<String, StringResource?> = Pair("", null),
    val password: Pair<String, StringResource?> = Pair("", null),
)

sealed interface SignInEvent {
    data class OnEmailChange(val newValue: String) : SignInEvent
    data class OnPasswordChange(val newValue: String) : SignInEvent
    data object OnSignUpClick : SignInEvent
    data object OnSignInClick : SignInEvent
    data object OnAnonymousClick : SignInEvent
}

sealed interface SignInSideEffect {
    data object NavigateToSignUpScreen : SignInSideEffect
    data object NavigateToHomeScreen : SignInSideEffect
}
