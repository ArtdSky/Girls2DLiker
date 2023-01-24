package com.example.girls2dliker.routing

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController


@Composable
fun NavState(orientation: String) {

    val navController = rememberNavController()

    NavGraph(navController = navController, orientation = orientation)
}
