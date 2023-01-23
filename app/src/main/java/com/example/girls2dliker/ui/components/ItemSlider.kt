package com.example.girls2dliker.ui.components

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.girls2dliker.data.network.dto.Images
import com.example.girls2dliker.viewmodel.MainViewModel
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.VerticalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel
import timber.log.Timber

@OptIn(
    ExperimentalPagerApi::class,
    ExperimentalMaterialApi::class
)
@SuppressLint("RememberReturnType", "SuspiciousIndentation", "UnrememberedMutableState")
@Composable
fun ItemSlider(
    data : List<Images>,
    screen: String,
    vm: MainViewModel
) {
    val state by vm.viewState.collectAsState()
//    val items = data
    var items: List<Images> = emptyList()

    when (screen) {
        "check" -> items = state.imageList
        "favorites" -> items = state.favoriteList.toList()
    }

    val pagerState = rememberPagerState(0)



    val refreshScope = rememberCoroutineScope()
    var refreshing by remember { mutableStateOf(false) }
    fun refresh() = refreshScope.launch {
        refreshing = true
        vm.loadData()
        vm.checkInFavorites( false )
        refreshing = false
    }
    val refreshState = rememberPullRefreshState(refreshing = refreshing, onRefresh = ::refresh)

    LaunchedEffect("$pagerState") {
        snapshotFlow { pagerState.currentPage }.collect { page ->
            if (items.isNotEmpty()) {
                vm.updateItemInfo(items[page])

                vm.checkInFavorites( state.favoriteList.contains(items[page]) )
            }
            Log.d("TAG-ItemSliderss", data.toString())

        }
    }

    Box(Modifier.pullRefresh(refreshState)) {
        if (!refreshing) {
            VerticalPager(count = items.size, state = pagerState) { page ->
                ScalableImage(items[page], modifier = Modifier)
            }
        }
        PullRefreshIndicator(refreshing, refreshState, Modifier.align(Alignment.TopCenter))
    }


}

























