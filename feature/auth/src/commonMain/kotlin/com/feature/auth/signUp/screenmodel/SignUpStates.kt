package com.feature.auth.signUp.screenmodel

import androidx.compose.runtime.Immutable
import org.jetbrains.compose.resources.StringResource

@Immutable
data class SignUpState(
    val signUpData: SignUpData = SignUpData(),
    val errorTextRes: StringResource? = null,
    val inLoading: Boolean = false
)

@Immutable
data class SignUpData(
    val name: Pair<String, StringResource?> = Pair("", null),
    val email: Pair<String, StringResource?> = Pair("", null),
    val password: Pair<String, StringResource?> = Pair("", null),
)

sealed interface SignUpEvent {
    data class OnNameChange(val newValue: String) : SignUpEvent
    data class OnEmailChange(val newValue: String) : SignUpEvent
    data class OnPasswordChange(val newValue: String) : SignUpEvent
    data object OnSignUpClick : SignUpEvent
    data object OnBackClick : SignUpEvent
}

sealed interface SignUpSideEffect {
    data object NavigateBack : SignUpSideEffect
    data object NavigateToHomeScreen : SignUpSideEffect
}
