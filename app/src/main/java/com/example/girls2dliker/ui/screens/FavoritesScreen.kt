package com.example.girls2dliker.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.girls2dliker.routing.AppDistination
import com.example.girls2dliker.routing.NavRoute
import com.example.girls2dliker.ui.components.AppDrawer
import com.example.girls2dliker.ui.components.ItemGrid
import com.example.girls2dliker.ui.components.ItemSlider
import com.example.girls2dliker.viewmodel.MainViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Composable
fun FavoritesScreen(
    orientation: String,
    navController: NavHostController,
    currentScreen : AppDistination,
    vm: MainViewModel
) {

    val state by vm.viewState.collectAsState()
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Favorites",
                        color = MaterialTheme.colors.onPrimary
                    )
                },
                navigationIcon = {
                    IconButton(onClick = {
                        coroutineScope.launch { scaffoldState.drawerState.open() }
                    }) {
                        Icon(
                            imageVector = Icons.Filled.List,
                            contentDescription = "Drawer Button"
                        )
                    }
                }
            )
        },
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
                    "portrait" -> ItemSlider(screen = "favorites", data = state.favoriteList, vm = vm)
                    "landscape" -> ItemGrid(screen = "favorites", navController = navController, vm = vm )
                }
            }
        },
        bottomBar = {},
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    state.itemInfo?.let { vm.deleteFromFavorite(it) }

                },
                contentColor = MaterialTheme.colors.background,
                content = {
                    Icon(
                        imageVector = Icons.Filled.Delete,
                        contentDescription = "Delete"
                    )
                }
            )
        }
    )
}