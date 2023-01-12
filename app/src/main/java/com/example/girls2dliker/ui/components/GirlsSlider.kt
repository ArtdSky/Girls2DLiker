package com.example.girls2dliker.ui.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@SuppressLint("RememberReturnType")
@Composable
fun GirlsSlider(
) {
    val gilsList = mutableListOf<String>(
        "https://cdn.waifu.im/7033.jpg",
        "https://cdn.waifu.im/7044.jpg",
        "https://cdn.waifu.im/7055.jpg",
        "https://cdn.waifu.im/7066.jpg",
        "https://cdn.waifu.im/7077.jpg",
    )
    val state = rememberLazyListState()

    LazyRow(
        modifier = Modifier.fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        state = state,
    ) {
        itemsIndexed(items = gilsList) { _, character ->
            ScalableImage(character)
        }

    }
}