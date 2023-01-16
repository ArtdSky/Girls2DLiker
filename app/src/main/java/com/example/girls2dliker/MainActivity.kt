package com.example.girls2dliker

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.example.girls2dliker.routing.Girls2DLikerRouter
import com.example.girls2dliker.routing.Screen
import com.example.girls2dliker.ui.screens.CheckScreen
import com.example.girls2dliker.ui.screens.FavoritesScreen
import com.example.girls2dliker.ui.theme.Girls2DLikerTheme
import com.example.girls2dliker.viewmodel.MainViewModel
import org.koin.androidx.compose.koinViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {



    @SuppressLint("ProduceStateDoesNotAssignValue")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

//            LaunchedEffect("test") {
//               val res = service.getPosts()
//                Log.d("TAG-MA", res.toString())
//            }

//            val posts = produceState<Response>(
//                initialValue = Response( emptyList() ),
//                producer = {
//                    value = service.getRandomImg()
//                }
//            )
//            Log.d("TAG-MA", "${posts.value}")

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
            is Screen.Favorites -> FavoritesScreen()
        }
    }
}