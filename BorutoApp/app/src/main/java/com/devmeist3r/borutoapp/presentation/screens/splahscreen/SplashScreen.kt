package com.devmeist3r.borutoapp.presentation.screens.splahscreen

import androidx.compose.animation.core.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.*
import androidx.compose.ui.tooling.preview.*
import androidx.hilt.navigation.compose.*
import androidx.navigation.*
import android.content.res.*
import com.devmeist3r.borutoapp.*
import com.devmeist3r.borutoapp.navigation.*
import com.devmeist3r.borutoapp.ui.theme.*

@Composable
fun SplashScreen(
    navController: NavHostController,
    splashViewModel: SplashViewModel = hiltViewModel(),
) {
    val onBoardingComplete = splashViewModel.onBoardingCompleted.collectAsState().value
    val degrees = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        degrees.animateTo(
            targetValue = 360f,
            animationSpec = tween(
                durationMillis = 1000,
                delayMillis = 200
            )
        )

        navController.popBackStack()

        if (onBoardingComplete) {
            navController.navigate(Screen.Home.route)
        } else {
            navController.navigate(Screen.Welcome.route)
        }

    }

    Splash(degrees = degrees.value)
}

@Composable
fun Splash(degrees: Float) {
    if (isSystemInDarkTheme()) {
        Box(
            modifier = Modifier
                .background(Color.Black)
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.rotate(degrees = degrees),
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = stringResource(R.string.app_logo)
            )
        }
    } else {
        Box(
            modifier = Modifier
                .background(
                    Brush.verticalGradient(
                        listOf(Purple700, Purple500)
                    )
                )
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier.rotate(degrees = degrees),
                painter = painterResource(id = R.drawable.ic_logo),
                contentDescription = stringResource(R.string.app_logo)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SplashScreenPreview() {
    Splash(degrees = 0f)
}

@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun SplashScreenDarkPreview() {
    Splash(degrees = 0f)
}
