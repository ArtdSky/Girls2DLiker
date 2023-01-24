package com.example.girls2dliker.ui.components

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.girls2dliker.data.network.dto.Images
import com.example.girls2dliker.routing.Image
import com.example.girls2dliker.routing.NavRoute
import com.example.girls2dliker.routing.navigateSingleTopTo
import com.example.girls2dliker.routing.navigateToSingleImage
import com.example.girls2dliker.viewmodel.MainViewModel
import org.koin.androidx.compose.koinViewModel

@SuppressLint("RememberReturnType")
@Composable
fun ItemGrid(
    screen: String,
    navController : NavHostController,
    vm: MainViewModel
) {
    val state by vm.viewState.collectAsState()
    var items: List<Images> = emptyList()

    when (screen) {
        "check" -> items = state.imageList
        "favorites" -> items = state.favoriteList
    }

    var selectedItem by remember { mutableStateOf<Int?>(null) }
    LazyVerticalGrid(
        columns = GridCells.Adaptive(minSize = 128.dp),
        contentPadding = PaddingValues(
            start = 12.dp,
            top = 16.dp,
            end = 12.dp,
            bottom = 16.dp
        )
    ) {
        items(items.size) { index ->
            ScalableImage(
                items[index],
                Modifier
                    .clickable {
                        selectedItem = index
                        vm.updateItemInfo(items[index])
                        navController.navigateSingleTopTo( Image.route )
                        Log.d("TAG-GRID", selectedItem.toString())
                    }
                    .size(200.dp)
            )
        }
    }
}