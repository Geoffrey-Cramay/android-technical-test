package com.etx.technical.test.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.etx.technical.test.navigation.ArgKeys.SONG_ID_ARG_KEY
import com.etx.technical.test.screens.ArtistsScreen
import com.etx.technical.test.screens.MediaScreen
import com.etx.technical.test.screens.PlayerScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screens.Artists.route
    )
    {
        composable(route = Screens.Artists.route) {
            ArtistsScreen(navController = navController)
        }
        composable(
            route = Screens.Media.route,
            arguments = listOf(navArgument(SONG_ID_ARG_KEY) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            MediaScreen(
                navController = navController,
                songId = backStackEntry.arguments?.getString(SONG_ID_ARG_KEY) ?: return@composable
            )
        }
        composable(
            route = Screens.Player.route,
            arguments = listOf(navArgument(SONG_ID_ARG_KEY) {
                type = NavType.StringType
            })
        ) { backStackEntry ->
            PlayerScreen(
                songId = backStackEntry.arguments?.getString(SONG_ID_ARG_KEY) ?: return@composable
            )
        }
    }
}