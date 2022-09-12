package com.example.composenavigation.screen

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import com.example.composenavigation.R
import com.example.composenavigation.screen.destinations.MainScreenDestination
import com.example.composenavigation.screen.destinations.SplashScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import kotlinx.coroutines.delay

private const val SPLASH_DELAY_MILLIS = 300L
private const val ANIM_DURATION_MILLIS = 300
private const val ANIM_OVERSHOOT = 1.2f

@Destination(start = true)
@Composable
fun SplashScreen(
    navigator: DestinationsNavigator
) {

    val scale = remember {
        Animatable(0f)
    }

    LaunchedEffect(Unit) {
        scale.animateTo(
            targetValue = 1.5f,
            animationSpec = tween(
                durationMillis = ANIM_DURATION_MILLIS,
                easing = {
                    OvershootInterpolator(ANIM_OVERSHOOT).getInterpolation(it)
                }
            )
        )
        delay(SPLASH_DELAY_MILLIS)
        navigator.navigate(MainScreenDestination()) {
            //        remove splash from stack
            popUpTo(SplashScreenDestination.route) {
                inclusive = true
            }
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.dragon),
            contentDescription = "Application logo",
            modifier = Modifier.scale(scale.value)
        )
    }
}