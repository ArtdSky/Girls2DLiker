package com.example.girls2dliker

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.produceState
import com.example.girls2dliker.data.network.ApiService
import com.example.girls2dliker.data.network.dto.Response
import com.example.girls2dliker.routing.Girls2DLikerRouter
import com.example.girls2dliker.routing.Screen
import com.example.girls2dliker.ui.screens.CheckScreen
import com.example.girls2dliker.ui.screens.FavoritesScreen
import com.example.girls2dliker.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {

    private val service = ApiService.create()

    private val viewModel: MainViewModel by viewModels { MainViewModel.Factory }

    @SuppressLint("ProduceStateDoesNotAssignValue")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

//            LaunchedEffect("test") {
//               val res = service.getPosts()
//                Log.d("TAG-MA", res.toString())
//            }

            val posts = produceState<Response>(
                initialValue = Response( emptyList() ),
                producer = {
                    value = service.getRandomImg()
                }
            )
            Log.d("TAG-MA", "${posts.value}")

//            Girls2DLikerTheme {
//                MainActivityScreen(viewModel = viewModel)
//            }
        }
    }
}

@Composable
fun MainActivityScreen(viewModel: MainViewModel) {
    Surface {
        when (Girls2DLikerRouter.currentScreen) {
            is Screen.Check -> CheckScreen(viewModel)
            is Screen.Favorites -> FavoritesScreen(viewModel)
        }
    }
}