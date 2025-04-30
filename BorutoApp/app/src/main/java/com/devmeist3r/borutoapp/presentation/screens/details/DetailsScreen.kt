package com.devmeist3r.borutoapp.presentation.screens.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.devmeist3r.borutoapp.util.Constants.BASE_URL
import com.devmeist3r.borutoapp.util.PaletteGenerator.convertImageUrlToBitmap
import com.devmeist3r.borutoapp.util.PaletteGenerator.extractColorsFromBitmap


@ExperimentalCoilApi
@Composable
fun DetailsScreen(
    navController: NavHostController,
    detailsViewModel: DetailsViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val selectedHero by detailsViewModel.selectedHero.collectAsState()
    val colorPalette by detailsViewModel.colorPalette
    val uiEvent = detailsViewModel.uiEvent

    LaunchedEffect(key1 = uiEvent) {
        when (uiEvent) {
            is UiEvent.GenerateColorPalette -> {
                val bitmap = convertImageUrlToBitmap(
                    imageUrl = "$BASE_URL${selectedHero?.image}",
                    context = context
                )
                if (bitmap != null) {
                    detailsViewModel.setColorPalette(
                        colors = extractColorsFromBitmap(
                            bitmap = bitmap
                        )
                    )
                }
            }
            else -> {}
        }
    }

    if (colorPalette.isNotEmpty()) {
        DetailsContent(
            navController = navController,
            selectedHero = selectedHero,
            colors = colorPalette
        )
    } else {
        detailsViewModel.generateColorPalette()
    }
}
