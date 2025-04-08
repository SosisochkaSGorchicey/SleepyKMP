package com.core.ui.uiElements.mainScreenElements

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import com.core.ui.Res
import com.core.ui.theme.AppTheme
import com.core.ui.theme.montserratFont
import com.core.ui.warning_default_confirm
import com.core.ui.warning_default_dismiss
import com.core.ui.warning_default_title
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun MainAlertDialog(
    onDismissRequest: () -> Unit,
    onDismiss: () -> Unit,
    dismissTextRes: StringResource = Res.string.warning_default_dismiss,
    onConfirmation: () -> Unit,
    confirmTextRes: StringResource = Res.string.warning_default_confirm,
    dialogTitle: String = stringResource(Res.string.warning_default_title),
    dialogText: String,
    icon: ImageVector = Icons.Outlined.Info
) {
    AlertDialog(
        icon = {
            Icon(icon, contentDescription = "Example Icon")
        },
        title = {
            Text(
                text = dialogTitle,
                style = AppTheme.typography.bodyMedium.copy(
                    textAlign = TextAlign.Center,
                    fontFamily = montserratFont
                )
            )
        },
        text = {
            Text(
                text = dialogText,
                style = AppTheme.typography.bodySmall.copy(
                    textAlign = TextAlign.Center,
                    fontFamily = montserratFont
                )
            )
        },
        onDismissRequest = onDismissRequest,
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text(
                    text = stringResource(confirmTextRes),
                    style = AppTheme.typography.bodySmallBold,
                    fontFamily = montserratFont,
                    color = AppTheme.colors.lightRed
                )
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismiss()
                }
            ) {
                Text(
                    text = stringResource(dismissTextRes),
                    style = AppTheme.typography.bodySmallBold,
                    fontFamily = montserratFont,
                    color = AppTheme.colors.baseBlue
                )
            }
        },
        containerColor = AppTheme.colors.superLightPeachy,
        titleContentColor = AppTheme.colors.baseBlue,
        textContentColor = AppTheme.colors.baseBlueLight,
        iconContentColor = AppTheme.colors.lightRed
    )
}
