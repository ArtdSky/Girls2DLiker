package com.example.girls2dliker.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FavoritesScreen(

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