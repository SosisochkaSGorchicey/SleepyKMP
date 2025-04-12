package com.feature.audioContent.presentation.main.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.core.ui.Res
import com.core.ui.audio_content_title_description
import com.core.ui.audio_content_title_text
import com.core.ui.theme.AppTheme
import org.jetbrains.compose.resources.stringResource

@Composable
fun Header(modifier: Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp)
            .background(AppTheme.colors.basePeachy)
            .padding(vertical = 10.dp, horizontal = 20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        Text(
            text = stringResource(resource = Res.string.audio_content_title_text),
            style = AppTheme.typography.bodyMediumBold
        )

        Text(
            text = stringResource(resource = Res.string.audio_content_title_description),
            style = AppTheme.typography.bodySmall
        )
    }
}
