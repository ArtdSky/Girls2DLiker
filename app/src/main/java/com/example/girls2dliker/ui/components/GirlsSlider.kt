package com.example.girls2dliker.ui.components

import android.annotation.SuppressLint

import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.girls2dliker.data.network.dto.Images
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.ui.graphics.Color
import com.example.girls2dliker.ui.theme.Purple200
import com.example.girls2dliker.viewmodel.MainViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalFoundationApi::class)
@SuppressLint("RememberReturnType")
@Composable
fun Slider(
    imageList : List<Images>,
    vm: MainViewModel = koinViewModel()
) {
    val state by vm.viewState.collectAsState()
    val stateLazyList = rememberLazyListState()
    val snappingLayout = remember(stateLazyList) { SnapLayoutInfoProvider(stateLazyList) }
    val flingBehavior = rememberSnapFlingBehavior(snappingLayout)


    LazyRow(
        modifier = Modifier
            .fillMaxSize()
            .background(state.dominantColor )
        ,
        verticalAlignment = Alignment.CenterVertically,
        state = stateLazyList,
        flingBehavior = flingBehavior
    ) {
        itemsIndexed(items = imageList) { _, item ->
                    ScalableImage(item = item)
        }
    }
}

























