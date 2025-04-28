package com.devmeist3r.borutoapp.presentation.screens.home

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import android.annotation.SuppressLint
import com.devmeist3r.borutoapp.presentation.common.ListContent

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@ExperimentalCoilApi
@Composable
fun HomeScreen(
    navController: NavHostController,
    homeViewModel: HomeViewModel = hiltViewModel()
) {
    val allHeroes = homeViewModel.getAllHeroes.collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            HomeTopBar(onSearchClicked = {})
        },
        content = {
            ListContent(
                heroes = allHeroes,
                navController = navController
            )
        }
    )
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    val navController = rememberNavController()
    HomeScreen(navController = navController)
}


