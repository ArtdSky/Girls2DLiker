package com.example.girls2dliker.ui.components

import android.util.Log
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.girls2dliker.R
import com.example.girls2dliker.data.network.dto.Images
import com.example.girls2dliker.viewmodel.MainViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ScalableImage(
    item: Images,
    vm: MainViewModel = koinViewModel()
) {
    var scale by remember { mutableStateOf(1f) }
    val state = rememberTransformableState { zoomChange, _, _ ->
        scale *= zoomChange
    }

//    vm.updateItemInfo(page)
//    Log.d("TAG-ScalableImage", item.toString())

    GlideImage(
        model = item.url,
        contentDescription = "test",
        contentScale = ContentScale.FillHeight,
        modifier = Modifier
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale,
            )
            .transformable(state = state)
            .fillMaxSize()
    ) {
        it
            .placeholder(R.drawable.ic_android_black_24dp)
            .error(R.drawable.error)
    }

}