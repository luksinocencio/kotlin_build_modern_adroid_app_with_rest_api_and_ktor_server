package com.devmeist3r.borutoapp.presentation.screens.welcome

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.devmeist3r.borutoapp.R
import com.devmeist3r.borutoapp.domain.model.OnBoardingPage
import com.devmeist3r.borutoapp.navigation.Screen
import com.devmeist3r.borutoapp.presentation.components.HorizontalPagerIndicator
import com.devmeist3r.borutoapp.ui.theme.*
import com.devmeist3r.borutoapp.util.Constants.LAST_ON_BOARDING_PAGE
import com.devmeist3r.borutoapp.util.Constants.ON_BOARDING_PAGE_COUNT

@ExperimentalAnimationApi
@Composable
fun WelcomeScreen(
    navController: NavHostController,
    welcomeViewModel: WelcomeViewModel = hiltViewModel()
) {
    val pages = listOf(
        OnBoardingPage.First,
        OnBoardingPage.Second,
        OnBoardingPage.Third
    )

    val pagerState = rememberPagerState(pageCount = { ON_BOARDING_PAGE_COUNT })

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = welcomeScreenBackgroundColor)
    ) {
        HorizontalPager(
            modifier = Modifier.weight(10f),
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) { position ->
            PagerScreen(onBoardingPage = pages[position])
        }
        HorizontalPagerIndicator(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterHorizontally),
            pagerState = pagerState,
            pageCount = pagerState.pageCount,
            activeColor = activeIndicatorColor,
            inactiveColor = inactiveIndicatorColor,
            indicatorWidth = PAGING_INDICATOR_WIDTH,
            spacing = PAGING_INDICATOR_SPACING
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

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth(0.5f)
                .fillMaxHeight(0.7f),
            painter = painterResource(id = onBoardingPage.image),
            contentDescription = stringResource(R.string.on_boarding_image)
        )
        Text(
            modifier = Modifier
                .fillMaxWidth(),
            text = onBoardingPage.title,
            color = titleColor,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = EXTRA_LARGE_PADDING)
                .padding(top = SMALL_PADDING),
            text = onBoardingPage.description,
            color = descriptionColor,
            fontSize = MaterialTheme.typography.bodyMedium.fontSize,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center
        )
    }
}

@ExperimentalAnimationApi
@Composable
fun FinishButton(
    modifier: Modifier,
    pagerState: PagerState,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .padding(horizontal = EXTRA_LARGE_PADDING),
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
            modifier = Modifier.fillMaxWidth(),
            visible = pagerState.currentPage == LAST_ON_BOARDING_PAGE
        ) {
            Button(
                onClick = onClick,
                colors = ButtonDefaults.buttonColors(
                    containerColor = buttonBackgroundColor,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Finish")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun FirstOnBoardingScreenPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = OnBoardingPage.First)
    }
}

@Composable
@Preview(showBackground = true)
fun SecondOnBoardingScreenPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = OnBoardingPage.Second)
    }
}

@Composable
@Preview(showBackground = true)
fun ThirdOnBoardingScreenPreview() {
    Column(modifier = Modifier.fillMaxSize()) {
        PagerScreen(onBoardingPage = OnBoardingPage.Third)
    }
}
