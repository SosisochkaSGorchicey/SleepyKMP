package com.core.ui.uiElements.mainScreenElements

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.core.ui.theme.AppTheme
import com.core.ui.theme.montserratFont

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainTopBar(
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
    titleText: String = "",
    containerColor: Color = AppTheme.colors.baseBlue
) {
    CenterAlignedTopAppBar(
        modifier = Modifier.clip(AppTheme.shapes.bottomCorners),
        title = {
            Text(
                text = titleText,
                style = AppTheme.typography.bodyMedium.copy(
                    textAlign = TextAlign.Center,
                    fontFamily = montserratFont
                )
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = containerColor,
            navigationIconContentColor = AppTheme.colors.baseBlue,
            titleContentColor = AppTheme.colors.milkyWhite
        ),
        navigationIcon = navigationIcon,
        actions = actions
    )
}
