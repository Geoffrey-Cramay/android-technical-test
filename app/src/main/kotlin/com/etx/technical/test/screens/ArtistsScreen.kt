package com.etx.technical.test.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.etx.technical.test.navigation.Screens
import com.etx.technical.test.ui.compose.ArtistsList

@Composable
fun ArtistsScreen(navController: NavHostController) {
    ArtistsList(modifier = Modifier) { artist ->
        navController.navigate(Screens.Media.getMediaScreenPath(artist.name))
    }
}