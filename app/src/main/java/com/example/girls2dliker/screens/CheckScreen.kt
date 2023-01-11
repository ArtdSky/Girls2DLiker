package com.example.girls2dliker.screens

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import com.example.girls2dliker.components.AppDrawer
import com.example.girls2dliker.routing.Screen
import com.example.girls2dliker.viewmodel.MainViewModel
import kotlinx.coroutines.launch
import timber.log.Timber

@Composable
fun CheckScreen(
    mViewModel: MainViewModel
) {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
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
            Text(
                text = "CheckScreen",
                modifier = Modifier.padding(it)
            )
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