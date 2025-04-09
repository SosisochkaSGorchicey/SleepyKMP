package com.feature.auth.signUp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.core.ui.Res
import com.core.ui.email_placeholder
import com.core.ui.name_placeholder
import com.core.ui.password_placeholder
import com.core.ui.sign_up
import com.core.ui.sign_up_header
import com.core.ui.theme.AppTheme
import com.core.ui.theme.mainFont
import com.core.ui.theme.montserratFont
import com.core.ui.uiElements.MainButton
import com.core.ui.uiElements.RoundedTextField
import com.feature.auth.signUp.screenmodel.SignUpEvent
import com.feature.auth.signUp.screenmodel.SignUpState
import org.jetbrains.compose.resources.stringResource

@Composable
fun SignUpCard(
    state: SignUpState,
    onEvent: (SignUpEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 24.dp, vertical = 32.dp)
            .fillMaxSize()
            .clip(AppTheme.shapes.mediumCornersDp)
            .background(AppTheme.colors.lightPeachy)
            .border(
                width = 4.dp,
                color = AppTheme.colors.basePeachy,
                shape = AppTheme.shapes.mediumCornersDp
            )
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Header()

        SignUpTextFields(
            state = state,
            onEvent = onEvent
        )

        MainButton(
            onClick = {
                onEvent(SignUpEvent.OnSignUpClick)
            },
            text = stringResource(resource = Res.string.sign_up),
            containerColor = AppTheme.colors.baseBlue,
            borderColor = AppTheme.colors.baseBlueLight
        )
    }
}

@Composable
private fun Header() {
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = stringResource(resource = Res.string.sign_up_header),
        color = AppTheme.colors.baseBlue,
        style = AppTheme.typography.headlineMedium.copy(
            textAlign = TextAlign.Center,
            fontFamily = mainFont
        )
    )
}

@Composable
private fun SignUpTextFields(
    state: SignUpState,
    onEvent: (SignUpEvent) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        RoundedTextField(
            modifier = Modifier.fillMaxWidth(),
            currentText = state.signUpData.name.first,
            placeholderText = stringResource(resource = Res.string.name_placeholder),
            onValueChange = {
                onEvent(SignUpEvent.OnNameChange(newValue = it))
            },
            errorTextRes = state.signUpData.name.second
        )

        RoundedTextField(
            modifier = Modifier.fillMaxWidth(),
            currentText = state.signUpData.email.first,
            placeholderText = stringResource(resource = Res.string.email_placeholder),
            onValueChange = {
                onEvent(SignUpEvent.OnEmailChange(newValue = it))
            },
            errorTextRes = state.signUpData.email.second,
            keyboardType = KeyboardType.Email
        )

        RoundedTextField(
            modifier = Modifier.fillMaxWidth(),
            currentText = state.signUpData.password.first,
            placeholderText = stringResource(resource = Res.string.password_placeholder),
            onValueChange = {
                onEvent(SignUpEvent.OnPasswordChange(newValue = it))
            },
            errorTextRes = state.signUpData.password.second,
            keyboardType = KeyboardType.Password,
            visualTransformation = PasswordVisualTransformation(mask = '\u25CF'),
        )
    }
}
