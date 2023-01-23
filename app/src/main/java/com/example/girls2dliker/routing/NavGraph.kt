package com.example.girls2dliker.routing

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.girls2dliker.ui.screens.CheckScreen
import com.example.girls2dliker.ui.screens.FavoritesScreen
import com.example.girls2dliker.ui.screens.ImageScreen
import com.example.girls2dliker.viewmodel.MainViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    orientation: String,
    vm : MainViewModel = koinViewModel()
) {
    NavHost(
        navController = navController,
        startDestination = NavRoute.Check.route
    ) {
        composable(route = "check") {
            CheckScreen(orientation = orientation, navController = navController, vm = vm)
        }

        composable(route = "favorites") {
            FavoritesScreen(orientation = orientation, navController = navController, vm = vm)
        }
        composable(route = "image") {
            ImageScreen(orientation = orientation)
        }
    }
}