package com.devmeist3r.borutoapp.presentation.screens.home

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            HomeTopBar(onSearchClicked = {})
        }
    ) {}
}
