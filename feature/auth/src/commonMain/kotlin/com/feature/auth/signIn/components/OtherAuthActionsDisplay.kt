package com.feature.auth.signIn.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.core.ui.Res
import com.core.ui.anonymous_sign_in
import com.core.ui.no_account_text
import com.core.ui.separator
import com.core.ui.theme.AppTheme
import com.core.ui.theme.mainFont
import com.core.ui.uiElements.MainButton
import com.feature.auth.signIn.screenmodel.SignInEvent
import org.jetbrains.compose.resources.stringResource

@Composable
fun OtherAuthActionsDisplay(
    onEvent: (SignInEvent) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(vertical = 40.dp, horizontal = 10.dp)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DividerElement()

        MainButton(
            onClick = { onEvent(SignInEvent.OnAnonymousClick) },
            text = stringResource(resource = Res.string.anonymous_sign_in)
        )

        MainButton(
            onClick = { onEvent(SignInEvent.OnSignUpClick) },
            text = stringResource(resource = Res.string.no_account_text),
            containerColor = AppTheme.colors.baseBlue,
            borderColor = AppTheme.colors.baseBlueLight,
            addImages = true
        )
    }
}

@Composable
private fun RowScope.Divider() {
    HorizontalDivider(
        modifier = Modifier
            .fillMaxWidth()
            .weight(1f),
        color = AppTheme.colors.baseBlueLight,
        thickness = 2.dp
    )
}

@Composable
private fun DividerElement() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.CenterHorizontally)
    ) {
        Divider()

        Text(
            text = stringResource(resource = Res.string.separator),
            style = AppTheme.typography.headlineSmall,
            fontFamily = mainFont,
            color = AppTheme.colors.baseBlueLight
        )

        Divider()
    }
}
