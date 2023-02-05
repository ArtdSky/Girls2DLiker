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
import com.example.girls2dliker.routing.NavState
import com.example.girls2dliker.ui.theme.Girls2DLikerTheme
import com.example.girls2dliker.viewmodel.MainViewModel
import org.koin.androidx.compose.koinViewModel

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
//        when (Girls2DLikerRouter.currentScreen) {
//            is Screen.Check -> CheckScreen(orientation = orientation)
//            is Screen.Favorites -> FavoritesScreen(orientation = orientation)
//            is Screen.Image -> ImageScreen(orientation = orientation)
//        }
        NavState(orientation)

    }
}