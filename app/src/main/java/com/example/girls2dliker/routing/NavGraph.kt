package com.example.girls2dliker.routing

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.girls2dliker.routing.SingleImage.urlTypeArg
import com.example.girls2dliker.ui.screens.CheckScreen
import com.example.girls2dliker.ui.screens.FavoritesScreen
import com.example.girls2dliker.ui.screens.SingleImageScreen
import com.example.girls2dliker.viewmodel.MainViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun NavGraph(
    navController: NavHostController,
    orientation: String,
    currentScreen: AppDistination,
    vm: MainViewModel = koinViewModel()
) {
    NavHost(
        navController = navController,
        startDestination = Check.route
    ) {
        composable(route = Check.route) {
            CheckScreen(
                orientation = orientation,
                navController = navController,
                currentScreen = currentScreen,
                vm = vm
            )
        }

        composable(route = Favorites.route) {
            FavoritesScreen(
                orientation = orientation,
                navController = navController,
                currentScreen = currentScreen,
                vm = vm
            )
        }
        composable(route = Image.route) {
            SingleImageScreen(
                orientation = orientation,
                vm = vm
            )
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) {
    this.navigate(route) {
        popUpTo(
            this@navigateSingleTopTo.graph.findStartDestination().id
        ) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

fun NavHostController.navigateToSingleImage(urlTypeArg: String) {
    this.navigateSingleTopTo("${SingleImage.route}/$urlTypeArg")
}