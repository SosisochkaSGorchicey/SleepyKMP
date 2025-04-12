package com.feature.audioContent.presentation.detail.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.core.ui.Res
import com.core.ui.icons.MyIconPack
import com.core.ui.icons.myiconpack.Stop
import com.core.ui.play_button
import com.core.ui.stop_button
import com.core.ui.theme.AppTheme
import org.jetbrains.compose.resources.stringResource

@Composable
fun PlayerButton(
    onPlayStop: () -> Unit,
    onSelect: () -> Unit,
    isPlaying: Boolean
) {
    val isSelected = rememberSaveable { //todo
        mutableStateOf(false)
    }

    Button(
        onClick = {
            if (isSelected.value) {
                onPlayStop()
            } else {
                isSelected.value = !isSelected.value
                onSelect()
            }
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = AppTheme.colors.baseBlue,
            contentColor = AppTheme.colors.milkyWhite
        ),
        shape = AppTheme.shapes.mediumCornersPercent
    ) {
        Text(
            text = if (isPlaying) stringResource(Res.string.stop_button)
            else stringResource(Res.string.play_button),
            style = AppTheme.typography.bodyMediumMedium
        )

        Icon(
            modifier = Modifier.size(28.dp),
            imageVector = if (isPlaying) MyIconPack.Stop else Icons.Default.PlayArrow,
            contentDescription = null
        )
    }
}
