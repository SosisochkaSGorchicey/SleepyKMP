package com.core.ui.shared

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.Dp

@OptIn(ExperimentalComposeUiApi::class)
actual val screenWidth: Dp
    @Composable get() = with(LocalDensity.current) {
        LocalWindowInfo.current.containerSize.width.toDp()
    }

@OptIn(ExperimentalComposeUiApi::class)
actual val screenHeight: Dp
    @Composable get() = with(LocalDensity.current) {
        LocalWindowInfo.current.containerSize.height.toDp()
    }
