package com.core.ui.shared

import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalComposeUiApi::class)
actual val screenWidth: Dp
    @Composable get() = LocalWindowInfo.current.containerSize.width.pxToPoint().dp

@OptIn(ExperimentalComposeUiApi::class)
actual val screenHeight: Dp
    @Composable get() = LocalWindowInfo.current.containerSize.height.pxToPoint().dp

private fun Int.pxToPoint(): Double = this.toDouble()
