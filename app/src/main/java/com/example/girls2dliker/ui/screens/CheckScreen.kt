package com.example.girls2dliker.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.example.girls2dliker.routing.Screen
import com.example.girls2dliker.ui.components.AppDrawer
import com.example.girls2dliker.ui.components.GirlsSlider
import com.example.girls2dliker.ui.components.ScalableImage
import com.example.girls2dliker.viewmodel.MainViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CheckScreen(
    mViewModel: MainViewModel
) {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
//            TopAppBar(
//                title = {
//                    Text(
//                        text = "girls2dliker",
//                        color = MaterialTheme.colors.onPrimary
//                    )
//                },
//                navigationIcon = {
//                    IconButton(onClick = {
//                        coroutineScope.launch { scaffoldState.drawerState.open() }
//                    }) {
//                        Icon(
//                            imageVector = Icons.Filled.List,
//                            contentDescription = "Drawer Button"
//                        )
//                    }
//                }
//            )
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
                GirlsSlider()

            }

        },
        bottomBar = {},
        floatingActionButtonPosition = FabPosition.Center,
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    Log.d("VM", "FAB CLICK2")
                },
                contentColor = MaterialTheme.colors.background,
                content = {
                    Icon(
                        imageVector = Icons.Filled.Favorite,
                        contentDescription = "Add Note Button"
                    )
                }
            )
        }
    )
}

