package com.devmeist3r.borutoapp.presentation.screens.details

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun DetailsScreen(
    navController: NavController,
    detailsViewModel: DetailsViewModel = hiltViewModel(),
) {
    val selectedHero = detailsViewModel.selectedHero

}
