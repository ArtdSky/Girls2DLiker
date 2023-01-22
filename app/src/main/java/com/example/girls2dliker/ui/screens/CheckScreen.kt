package com.example.girls2dliker.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.Red
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.example.girls2dliker.routing.Screen
import com.example.girls2dliker.ui.components.AppDrawer
import com.example.girls2dliker.ui.components.ItemGrid
import com.example.girls2dliker.ui.components.ItemSlider
import com.example.girls2dliker.ui.theme.Purple200
import com.example.girls2dliker.viewmodel.MainViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CheckScreen(
    orientation: String,
    vm: MainViewModel = koinViewModel()
) {
    val state by vm.viewState.collectAsState()
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    val liked = remember { mutableStateOf(false) }

    state.itemInfo?.let {
        liked.value = state.favoriteList.contains(it)
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "girls2dliker",
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
                currentScreen = Screen.Check,
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
                    "portrait" -> ItemSlider(screen = "check")
                    "landscape" -> ItemGrid(screen = "check")
                }

            }

        },
        bottomBar = {},
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    state.itemInfo?.let {
                        if (!state.favoriteList.contains(it)) {
                            vm.addToFavorite(it)
                        }
                    }
                },
                backgroundColor = if (liked.value) Purple200 else Green,
                contentColor = MaterialTheme.colors.background,
                content = {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Add Note Button",
                        tint = if (liked.value) Red else Purple200,
                    )
                }
            )
        }
    )
}

