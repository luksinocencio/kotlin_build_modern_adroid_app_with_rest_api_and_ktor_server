package com.devmeist3r.borutoapp.presentation.screens.search

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun SearchScreen(navController: NavHostController) {
    Scaffold(
        topBar = {
            SearchTopBar(
                text = "",
                onTextChange = {},
                onSearchClicked = {},
                onCloseClicked = {}
            )
        }
    ) {}
}

@Preview
@Composable
private fun SearchScreenPreview() {
    val navController = rememberNavController()
    SearchScreen(navController = navController)
}
