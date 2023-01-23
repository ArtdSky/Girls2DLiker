package com.example.girls2dliker.routing

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.girls2dliker.viewmodel.MainViewModel
import org.koin.androidx.compose.koinViewModel


@Composable
fun NavState(orientation : String){

    val navController = rememberNavController()

    NavGraph(navController = navController, orientation = orientation)
}
