package com.example.girls2dliker.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import androidx.navigation.NavHostController
import com.example.girls2dliker.routing.AppDistination
import com.example.girls2dliker.ui.components.AppDrawer
import com.example.girls2dliker.ui.components.ItemGrid
import com.example.girls2dliker.ui.components.ItemSlider
import com.example.girls2dliker.ui.theme.Purple200
import com.example.girls2dliker.viewmodel.MainViewModel
import kotlinx.coroutines.launch

@Composable
fun CheckScreen(
    orientation: String,
    navController: NavHostController,
    currentScreen: AppDistination,
    vm: MainViewModel
) {
    val state by vm.viewState.collectAsState()
    val liked by vm.containInFavorites.collectAsState()

    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(

        scaffoldState = scaffoldState,
        drawerContent = {
            AppDrawer(
                currentScreen = currentScreen,
                navController = navController,
                closeDrawerAction = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.close()
                    }
                }
            )
        },
        content = {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
            ) {
                when (orientation) {
                    "portrait" -> ItemSlider(screen = "check", data = state.imageList, vm = vm)
                    "landscape" -> ItemGrid(
                        screen = "check",
                        navController = navController,
                        vm = vm
                    )
                }

            }

        },
        bottomBar = {},
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    Log.d("TAG-CHECKSCREEN", state.itemInfo.toString())
                    state.itemInfo?.let {
                        if (!state.favoriteList.contains(it)) {
                            vm.addToFavorite(it)
                            vm.checkInFavorites(true)
                        }
                    }
                },
                backgroundColor = if (liked) Purple200 else Green,
                contentColor = MaterialTheme.colors.background,
                content = {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Add Button",
                        tint = if (liked) Red else Purple200,
                    )
                }
            )
        }
    )
}

