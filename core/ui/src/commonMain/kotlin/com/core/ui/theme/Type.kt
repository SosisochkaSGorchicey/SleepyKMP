package com.core.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Immutable
class AppTypography(
    val headlineLarge: TextStyle = TextStyle(
        fontSize = 72.sp,
        textAlign = TextAlign.Center,
        //fontFamily = mainFont
    ),
    val headlineMedium: TextStyle = TextStyle(
        fontSize = 32.sp,
        textAlign = TextAlign.Start,
        //fontFamily = mainFont
    ),
    val headlineSmall: TextStyle = TextStyle(
        fontSize = 20.sp,
        textAlign = TextAlign.Start,
        //fontFamily = mainFont,
    ),
    val bodyLarge: TextStyle = TextStyle(
        fontSize = 28.sp,
        textAlign = TextAlign.Start,
        //fontFamily = montserratFont,
        fontWeight = FontWeight.Medium
    ),
    val bodyMedium: TextStyle = TextStyle(
        fontSize = 20.sp,
        textAlign = TextAlign.Start,
        //fontFamily = montserratFont,
        fontWeight = FontWeight.Normal
    ),
    val bodySmall: TextStyle = TextStyle(
        fontSize = 16.sp,
        textAlign = TextAlign.Start,
        //fontFamily = montserratFont,
        fontWeight = FontWeight.Normal
    ),
    val bodySmallBold: TextStyle = TextStyle(
        fontSize = 16.sp,
        textAlign = TextAlign.Start,
        //fontFamily = montserratFont,
        fontWeight = FontWeight.Medium
    ),
    val bodySuperSmall: TextStyle = TextStyle(
        fontSize = 14.sp,
        textAlign = TextAlign.Start,
        //fontFamily = montserratFont,
        fontWeight = FontWeight.Normal
    ),
    val bodyMediumMedium: TextStyle = TextStyle(
        fontSize = 20.sp,
        textAlign = TextAlign.Start,
        //fontFamily = montserratFont,
        fontWeight = FontWeight.Medium
    ),
    val bodyMediumBold: TextStyle = TextStyle(
        fontSize = 20.sp,
        textAlign = TextAlign.Start,
        //fontFamily = montserratFont,
        fontWeight = FontWeight.SemiBold
    ),
    val bodyLargeBold: TextStyle = TextStyle(
        fontSize = 30.sp,
        textAlign = TextAlign.Start,
        //fontFamily = montserratFont,
        fontWeight = FontWeight.SemiBold
    )
)

internal val LocalAppTypography = staticCompositionLocalOf { AppTypography() }