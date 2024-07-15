package ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.EaseInOut
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun colorAnimation(
    targetColor: Color,
    durationMillis: Int
): Color = animateColorAsState(
    label = "Color",
    targetValue = targetColor,
    animationSpec = tween(
        durationMillis = durationMillis,
        easing = EaseInOut
    )
).value