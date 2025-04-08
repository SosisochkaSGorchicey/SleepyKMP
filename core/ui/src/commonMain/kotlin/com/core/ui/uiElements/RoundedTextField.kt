package com.core.ui.uiElements

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import com.core.ui.theme.AppTheme
import com.core.ui.theme.montserratFont
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun RoundedTextField(
    modifier: Modifier = Modifier.fillMaxWidth(),
    currentText: String,
    placeholderText: String,
    onValueChange: (String) -> Unit,
    errorTextRes: StringResource? = null,
    keyboardType: KeyboardType = KeyboardType.Text,
    visualTransformation: VisualTransformation = VisualTransformation.None,
) {
    Column(
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = errorTextRes?.let { stringResource(resource = it) } ?: "",
            style = AppTheme.typography.bodySuperSmall,
            fontFamily = montserratFont,
            color = AppTheme.colors.baseRed
        )

        SelectionContainer {
            OutlinedTextField(
                modifier = modifier,
                value = currentText,
                onValueChange = onValueChange,
                shape = AppTheme.shapes.rounded,
                singleLine = true,
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = AppTheme.colors.baseBlue.copy(alpha = .6f),
                    unfocusedBorderColor = AppTheme.colors.basePeachy,
                    focusedContainerColor = AppTheme.colors.milkyWhite,
                    unfocusedContainerColor = AppTheme.colors.milkyWhite,
                    focusedTextColor = AppTheme.colors.baseBlue,
                    unfocusedTextColor = AppTheme.colors.baseBlue.copy(alpha = .6f),
                    focusedPlaceholderColor = AppTheme.colors.baseBlue.copy(alpha = .6f),
                    unfocusedPlaceholderColor = AppTheme.colors.baseBlue.copy(alpha = .6f),
                    cursorColor = AppTheme.colors.baseBlue,
                    selectionColors = TextSelectionColors(
                        handleColor = AppTheme.colors.baseBlue,
                        backgroundColor = AppTheme.colors.baseBlue.copy(alpha = .3f)
                    ),
                    errorTextColor = AppTheme.colors.baseRed,
                    errorContainerColor = AppTheme.colors.milkyWhite,
                    errorBorderColor = AppTheme.colors.baseRed
                ),
                textStyle = AppTheme.typography.bodyMedium.copy(fontFamily = montserratFont),
                placeholder = {
                    Text(
                        text = placeholderText,
                        style = AppTheme.typography.bodySmall,
                        fontFamily = montserratFont
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = keyboardType),
                visualTransformation = visualTransformation,
                isError = errorTextRes != null
            )
        }
    }
}
