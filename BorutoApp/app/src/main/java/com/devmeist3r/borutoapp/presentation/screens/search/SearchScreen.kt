package com.devmeist3r.borutoapp.presentation.screens.search

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.compose.runtime.getValue

@Composable
fun SearchScreen(
    navController: NavHostController,
    searchViewModel: SearchViewModel = hiltViewModel()
) {
    val searchQuery by searchViewModel.searchQuery

    Scaffold(
        topBar = {
            SearchTopBar(
                text = searchQuery,
                onTextChange = { searchViewModel.updateSearchQuery(query = it)},
                onSearchClicked = {},
                onCloseClicked = {
                    navController.popBackStack()
                }
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
