package com.example.girls2dliker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.example.girls2dliker.routing.Girls2DLikerRouter
import com.example.girls2dliker.routing.Screen
import com.example.girls2dliker.ui.screens.CheckScreen
import com.example.girls2dliker.ui.screens.FavoritesScreen
import com.example.girls2dliker.ui.theme.Girls2DLikerTheme
import com.example.girls2dliker.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels { MainViewModel.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Girls2DLikerTheme {
                MainActivityScreen(viewModel = viewModel)
            }
        }
    }
}

@Composable
fun MainActivityScreen(viewModel : MainViewModel ) {
    Surface {
        when (Girls2DLikerRouter.currentScreen) {
            is Screen.Check -> CheckScreen(viewModel)
            is Screen.Favorites -> FavoritesScreen(viewModel)
        }
    }
}