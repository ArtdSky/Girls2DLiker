package com.example.girls2dliker.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.girls2dliker.viewmodel.MainViewModel

@Composable
fun FavoritesScreen(
    mViewModel : MainViewModel
) {
    Scaffold(
        content = {
            Text(
                text = "FavoriteScreen",
                modifier = Modifier.padding(it)
            )
        }
    )
}