package com.feature.auth.signUp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.core.ui.Res
import com.core.ui.flower_dark_face
import org.jetbrains.compose.resources.painterResource

@Composable
fun BoxScope.SignUpBackground() {
    Image(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(.4f)
            .align(Alignment.BottomStart)
            .rotate(-25f),
        painter = painterResource(resource = Res.drawable.flower_dark_face),
        contentDescription = null,
        contentScale = ContentScale.FillWidth
    )

    Image(
        modifier = Modifier
            .padding(20.dp)
            .fillMaxWidth(.3f)
            .align(Alignment.TopEnd)
            .rotate(25f),
        painter = painterResource(resource = Res.drawable.flower_dark_face),
        contentDescription = null,
        contentScale = ContentScale.FillWidth
    )
}
