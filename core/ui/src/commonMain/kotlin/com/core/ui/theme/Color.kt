package com.core.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color


private val White = Color(0xFFFFFFFF)
private val Black = Color(0xFF000000)
private val DarkGrey = Color(0xFF151717)
private val Transparent = Color.Transparent
private val Purple = Color(0xFFD829E9)
private val Pink = Color(0xFF421AF8)
private val DarkPurple = Color(0xFF170D25)
private val BrightPurple = Color(0xFF751FF2)
private val LightPurple = Color(0xFF859AF4)
private val Grey = Color(0xFF3A3A42)
private val LightGrey = Color(0xFF8D8E99)
private val DarkBlue = Color(0xFF0D0922)
private val Red = Color(0xFFFF5858)
private val BorderGradient = Brush.linearGradient(
    listOf(
        Color.White.copy(.2f),
        Color.Transparent,
        Color.Black.copy(alpha = .3f),
    )
)
private val PinkPurpleGradient = Brush.linearGradient(listOf(Pink, Purple))
private val PinkPurpleGradientTransparent = Brush.linearGradient(
    listOf(Pink.copy(alpha = .4f), Purple.copy(alpha = .4f))
)

internal val DarkColorScheme = darkColorScheme(
    background = DarkGrey,
    onBackground = White,
    primary = Purple,
    onPrimary = White,
)

@Immutable
data class AppColors(
    val transparent: Color = Transparent,
    val white: Color = White,
    val black: Color = Black,
    val purple: Color = Purple,
    val darkPurple: Color = DarkPurple,
    val lightPurple: Color = LightPurple,
    val brightPurple: Color = BrightPurple,
    val borderGradient: Brush = BorderGradient,
    val pinkPurpleGradient: Brush = PinkPurpleGradient,
    val pinkPurpleGradientTransparent: Brush = PinkPurpleGradientTransparent,
    val grey: Color = Grey,
    val darkBlue: Color = DarkBlue,
    val lightGrey: Color = LightGrey,
    val red: Color = Red,
)

internal val LocalAppColors = staticCompositionLocalOf { AppColors() }
