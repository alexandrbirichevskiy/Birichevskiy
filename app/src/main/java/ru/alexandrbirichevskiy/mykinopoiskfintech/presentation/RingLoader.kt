package ru.alexandrbirichevskiy.mykinopoiskfintech.presentation

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.Crossfade
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import ru.alexandrbirichevskiy.mykinopoiskfintech.R

@Composable
fun RingLoader(
    modifier: Modifier = Modifier,
    color: Color = Color.White,
    animateIndicator: Boolean = true,
    fraction: Float = 0f,
    thickness: Dp = 3.dp
) {
    var internalAnimate by remember {
        mutableStateOf(animateIndicator)
    }
    LaunchedEffect(key1 = animateIndicator) {
        if (animateIndicator) {
            internalAnimate = animateIndicator
        }
    }
    Crossfade(
        targetState = internalAnimate,
        animationSpec = tween(durationMillis = 100)
    ) { infiniteAnimate ->
        Box(
            modifier = modifier
        ) {
            if (!infiniteAnimate) {
                Indicator(
                    thickness = thickness,
                    color = color,
                    angle = fraction * 360
                )
            } else {
                val transition = rememberInfiniteTransition()
                val newAngle by transition.animateFloat(
                    initialValue = 0f,
                    targetValue = 360f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(easing = LinearEasing, durationMillis = 900),
                        repeatMode = RepeatMode.Restart
                    )
                )
                Indicator(thickness = thickness, color = color, angle = newAngle)
            }
        }
    }
}

@Composable
fun Indicator(
    thickness: Dp,
    color: Color,
    angle: Float
) {
    Canvas(
        modifier = Modifier
            .fillMaxSize()
            .padding(thickness / 2)
    ) {
        rotate(
            degrees = angle,
        ) {
            drawArc(
                brush = Brush.sweepGradient(-0.25f to Color.Transparent, 0.75f to color),
                startAngle = 0f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(
                    width = thickness.toPx(),
                    cap = StrokeCap.Square
                )
            )
        }
    }
}

@Composable
fun RingLoaderInBox(
    isLoading: Boolean,
    color: Color = Color.White,
    ringColor: Color = colorResource(id = R.color.blue)
) {
    AnimatedVisibility(
        visible = isLoading,
        enter = fadeIn(initialAlpha = 0.4f),
        exit = fadeOut(animationSpec = tween())
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize(),
            color = color
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .systemBarsPadding()
                    .imePadding(), contentAlignment = Alignment.Center
            ) {
                Column(
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    RingLoader(
                        color = ringColor,
                        thickness = 6.dp,
                        modifier = Modifier.size(56.dp)
                    )
                }
            }
        }
    }
}