package com.devmeist3r.borutoapp.presentation.screens.welcome

import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.*
import androidx.compose.ui.text.font.*
import androidx.compose.ui.text.style.*
import androidx.compose.ui.tooling.preview.*
import androidx.hilt.navigation.compose.*
import androidx.navigation.*
import androidx.navigation.compose.*
import com.google.accompanist.pager.*
import com.devmeist3r.borutoapp.*
import com.devmeist3r.borutoapp.domain.model.*
import com.devmeist3r.borutoapp.navigation.Screen
import com.devmeist3r.borutoapp.ui.theme.*
import com.devmeist3r.borutoapp.util.*
import com.devmeist3r.borutoapp.util.Constants.LAST_ON_BOARDING_PAGE

@ExperimentalAnimationApi
@OptIn(ExperimentalPagerApi::class)
@Composable
fun WelcomeScreen(
    navController: NavController,
    welcomeViewModel: WelcomeViewModel = hiltViewModel(),
) {
    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third
    )

    val pagerState = rememberPagerState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.welcomeScreenBackground)
    ) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            state = pagerState,
            count = Constants.ON_BOARDING_PAGE_COUNT,
            verticalAlignment = Alignment.Top
        ) { position ->
            PagerScreen(onBoardingPage = pages[position])
        }
        HorizontalPagerIndicator(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            pagerState = pagerState,
            activeColor = MaterialTheme.colors.activeIndicatorColor,
            inactiveColor = MaterialTheme.colors.inactiveIndicatorColor,
            indicatorWidth = PAGING_INDICATOR_SIZE,
            spacing = PAGING_INDICATOR_SPACING,
        )
        FinishButton(
            modifier = Modifier.weight(1f),
            pagerState = pagerState
        ) {
            navController.popBackStack()
            navController.navigate(Screen.Home.route)
            welcomeViewModel.saveOnBoardingState(completed = true)
        }
    }
}

@OptIn(ExperimentalPagerApi::class)
@Composable
fun FinishButton(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    onClick: () -> Unit,
) {
    Row(
        modifier = modifier
            .padding(horizontal = EXTRA_LARGE_PADDING),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = pagerState.currentPage == LAST_ON_BOARDING_PAGE,
        ) {
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.buttonBackgroundColor,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Finish")
            }
        }
    }
}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            painterResource(id = onBoardingPage.image),
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.7f),
            contentDescription = stringResource(R.string.on_boarding_image)
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = EXTRA_LARGE_PADDING),
            text = onBoardingPage.title,
            color = MaterialTheme.colors.titleColor,
            fontSize = MaterialTheme.typography.h4.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = EXTRA_LARGE_PADDING)
                .padding(top = SMALL_PADDING),
            text = onBoardingPage.description,
            color = MaterialTheme.colors.descriptionColor,
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}

@OptIn(ExperimentalAnimationApi::class)
@Preview(showBackground = true)
@Composable
private fun WelcomeScreenPreview() {
    val navController = rememberNavController()
    WelcomeScreen(navController = navController)
}
