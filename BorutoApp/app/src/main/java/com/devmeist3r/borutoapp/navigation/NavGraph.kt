package com.devmeist3r.borutoapp.navigation

import androidx.compose.animation.*
import androidx.compose.runtime.*
import androidx.navigation.*
import androidx.navigation.compose.*
import com.google.accompanist.pager.*
import com.devmeist3r.borutoapp.presentation.screens.home.*
import com.devmeist3r.borutoapp.presentation.screens.splahscreen.*
import com.devmeist3r.borutoapp.presentation.screens.welcome.*
import com.devmeist3r.borutoapp.util.Constants.DETAILS_ARGUMENT_KEY

@ExperimentalAnimationApi
@OptIn(ExperimentalPagerApi::class)
@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(route = Screen.Splash.route) {
            SplashScreen(navController = navController)
        }
        composable(route = Screen.Welcome.route) {
            WelcomeScreen(navController = navController)
        }
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.Details.route,
            arguments = listOf(navArgument(DETAILS_ARGUMENT_KEY) {
                type = NavType.IntType
            })
        ) {

        }
        composable(route = Screen.Search.route) {

        }
    }
}
