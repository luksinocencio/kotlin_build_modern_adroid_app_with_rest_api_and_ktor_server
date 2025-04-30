package com.devmeist3r.borutoapp.presentation.screens.home

import android.app.Activity
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.devmeist3r.borutoapp.navigation.Screen
import com.devmeist3r.borutoapp.presentation.common.ListContent
import com.devmeist3r.borutoapp.ui.theme.statusBarColor
import com.devmeist3r.borutoapp.ui.theme.welcomeScreenBackgroundColor

@ExperimentalCoilApi
@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val activity = LocalContext.current as Activity
    val allHeroes = homeViewModel.getAllHeroes.collectAsLazyPagingItems()
    val systemBarColor = statusBarColor.toArgb()

    SideEffect { activity.window.statusBarColor = systemBarColor }

    Scaffold(
        topBar = {
            HomeTopBar(
                onSearchClicked = {
                    navController.navigate(Screen.Search.route)
                }
            )
        },
        containerColor = welcomeScreenBackgroundColor,
        content = { padding ->
            ListContent(
                padding = padding,
                heroes = allHeroes,
                navController = navController
            )
        }
    )
}
