package com.example.girls2dliker.ui.components

import android.annotation.SuppressLint
import android.graphics.Color.parseColor
import android.util.Log
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.girls2dliker.data.network.dto.Images
import com.example.girls2dliker.ui.theme.Purple200
import com.example.girls2dliker.viewmodel.MainViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalFoundationApi::class, ExperimentalPagerApi::class)
@SuppressLint("RememberReturnType")
@Composable
fun ItemSlider(
    imageList: List<Images>,
    vm: MainViewModel = koinViewModel()
) {
    val state by vm.viewState.collectAsState()

    val pagerState = rememberPagerState()

        if(state.imageList.isNotEmpty()) {
            vm.updateItemInfo(state.imageList[pagerState.currentPage])
        }

    HorizontalPager(count = imageList.size, state = pagerState,) { page ->
        ScalableImage(imageList[page])
    }
}

























