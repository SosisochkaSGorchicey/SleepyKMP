package com.core.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.core.ui.Res
import com.core.ui.main
import com.core.ui.montserrat_medium
import com.core.ui.montserrat_regular
import com.core.ui.montserrat_semibold
import org.jetbrains.compose.resources.Font


val mainFont
    @Composable get() = FontFamily(
        Font(Res.font.main)
    )

val montserratFont
    @Composable get() = FontFamily(
        Font(resource = Res.font.montserrat_regular, weight = FontWeight.Normal),
        Font(resource = Res.font.montserrat_medium, weight = FontWeight.Medium),
        Font(resource = Res.font.montserrat_semibold, weight = FontWeight.SemiBold),
    )