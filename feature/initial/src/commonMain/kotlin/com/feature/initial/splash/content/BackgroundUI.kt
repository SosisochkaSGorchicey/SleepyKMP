package com.feature.initial.splash.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import com.core.ui.Res
import com.core.ui.dark_form
import com.core.ui.flower_dark_face
import com.core.ui.flower_light_face
import com.core.ui.light_form
import com.core.ui.theme.AppTheme
import org.jetbrains.compose.resources.painterResource

@Composable
fun BackgroundUI() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = AppTheme.colors.blueToGrayGradientLinear)
    ) {
        Image(
            modifier = Modifier
                .fillMaxHeight(.75f)
                .align(Alignment.BottomStart),
            painter = painterResource(resource = Res.drawable.light_form),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            alignment = Alignment.BottomStart
        )

        Image(
            modifier = Modifier
                .fillMaxHeight(.4f)
                .align(Alignment.BottomStart),
            painter = painterResource(resource = Res.drawable.dark_form),
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
            alignment = Alignment.TopEnd
        )

        Image(
            modifier = smallMovingElementModifier()
                .rotate(getRotateAnimationSmall()),
            painter = painterResource(resource = Res.drawable.flower_light_face),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )

        Image(
            modifier = bigMovingElementModifier()
                .rotate(getRotateAnimationBig()),
            painter = painterResource(resource = Res.drawable.flower_dark_face),
            contentDescription = null,
            contentScale = ContentScale.FillWidth
        )
    }
}
