package com.core.ui.shared

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

actual val screenWidth: Dp
    @Composable get() = LocalConfiguration.current.screenWidthDp.dp

actual val screenHeight: Dp
    @Composable get() = LocalConfiguration.current.screenHeightDp.dp
