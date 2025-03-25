package com.core.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Immutable
class AppTypography(
    val headlineMedium: TextStyle = TextStyle(
        fontWeight = FontWeight.W600,
        fontSize = 32.sp,
        lineHeight = 36.sp,
        letterSpacing = 1.2.sp,
        textAlign = TextAlign.Start
    ),
    val bodySmall: TextStyle = TextStyle(
        fontWeight = FontWeight.W200,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = 1.1.sp,
        textAlign = TextAlign.Start
    ),
    val bodySmallBold: TextStyle = TextStyle(
        fontWeight = FontWeight.W500,
        fontSize = 16.sp,
        lineHeight = 20.sp,
        letterSpacing = 1.2.sp,
        textAlign = TextAlign.Start
    ),
    val bodyMedium: TextStyle = TextStyle(
        fontWeight = FontWeight.W600,
        fontSize = 24.sp,
        lineHeight = 28.sp,
        letterSpacing = 1.1.sp,
        textAlign = TextAlign.Center
    ),
    val cardHeadline: TextStyle = TextStyle(
        fontWeight = FontWeight.W600,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        textAlign = TextAlign.Start
    ),
    val cardReadText: TextStyle = TextStyle(
        fontWeight = FontWeight.W200,
        fontSize = 14.sp,
        lineHeight = 16.sp,
        textAlign = TextAlign.Start
    ),
    val descriptionText: TextStyle = TextStyle(
        fontWeight = FontWeight.W400,
        fontSize = 12.sp,
        lineHeight = 14.sp,
        textAlign = TextAlign.Center
    ),
)

internal val LocalAppTypography = staticCompositionLocalOf { AppTypography() }
