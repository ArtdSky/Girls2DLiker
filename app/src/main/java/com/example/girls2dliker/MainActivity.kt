package com.example.girls2dliker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.girls2dliker.routing.Girls2DLikerRouter
import com.example.girls2dliker.routing.Screen
import com.example.girls2dliker.screens.CheckScreen
import com.example.girls2dliker.screens.FavoriteScreen
import com.example.girls2dliker.ui.theme.Girls2DLikerTheme
import timber.log.Timber

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Girls2DLikerTheme {
                MainActivityScreen()
            }
        }
    }
}

@Composable
fun MainActivityScreen() {
    Surface {
        when (Girls2DLikerRouter.currentScreen) {
            is Screen.Check -> CheckScreen()
            is Screen.Favorite -> FavoriteScreen()
        }
    }
}