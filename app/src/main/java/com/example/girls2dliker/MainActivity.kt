package com.example.girls2dliker

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import com.example.girls2dliker.routing.Girls2DLikerRouter
import com.example.girls2dliker.routing.Screen
import com.example.girls2dliker.ui.screens.CheckScreen
import com.example.girls2dliker.ui.screens.FavoritesScreen
import com.example.girls2dliker.ui.screens.ImageScreen
import com.example.girls2dliker.ui.theme.Girls2DLikerTheme

class MainActivity : ComponentActivity() {


    @SuppressLint("ProduceStateDoesNotAssignValue")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            Girls2DLikerTheme {
                when (LocalConfiguration.current.orientation) {
                    Configuration.ORIENTATION_LANDSCAPE -> {
                        MainActivityScreen(orientation = "landscape")
                    }
                    else -> {
                        MainActivityScreen(orientation = "portrait")
                    }
                }
            }
        }
    }
}

@Composable
fun MainActivityScreen(orientation: String) {
    Surface {
        when (Girls2DLikerRouter.currentScreen) {
            is Screen.Check -> CheckScreen(orientation = orientation)
            is Screen.Favorites -> FavoritesScreen(orientation = orientation)
            is Screen.Image -> ImageScreen(orientation = orientation)
        }
    }
}