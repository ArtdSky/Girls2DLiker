package com.example.girls2dliker.routing

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


@Composable
fun NavState(orientation: String) {

    val navController = rememberNavController()
    val currentBackStack by navController.currentBackStackEntryAsState()
    val currentDestination = currentBackStack?.destination
    val currentScreen = AppTabRowScreens.find {
        it.route == currentDestination?.route
    } ?: Check

    NavGraph(navController = navController, orientation = orientation, currentScreen = currentScreen)
}
