package com.example.girls2dliker.ui.screens

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
import com.example.girls2dliker.viewmodel.MainViewModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun SingleImageScreen(
    orientation: String,
    vm: MainViewModel
) {
    val state by vm.viewState.collectAsState()
    var scale by remember { mutableStateOf(1f) }
    val stateTransform = rememberTransformableState { zoomChange, _, _ ->
        scale *= zoomChange
    }

    Log.d("TAG-SingleImageScreen", state.itemInfo?.url.toString())
    state.itemInfo?.let { images ->
        GlideImage(
            model = images.url,
            contentDescription = "test",
            contentScale = ContentScale.FillHeight,
            modifier = Modifier
                .graphicsLayer(
                    scaleX = scale,
                    scaleY = scale,
                )
                .transformable(state = stateTransform)
                .fillMaxSize()
        ) {
            it
                .placeholder(R.drawable.ic_android_black_24dp)
                .error(R.drawable.error)
        }
    }


}