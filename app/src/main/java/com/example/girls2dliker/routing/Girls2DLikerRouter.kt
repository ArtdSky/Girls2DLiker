package com.example.girls2dliker.routing

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

object Girls2DLikerRouter {

    var currentScreen: Screen by mutableStateOf(Screen.Check)

    fun navigateTo(destination: Screen) {
        currentScreen = destination
    }
}