package com.example.girls2dliker.ui.screens

import android.util.Log
import androidx.activity.compose.BackHandler
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
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ImageScreen(
    orientation : String,
    vm: MainViewModel = koinViewModel()
) {
    Log.d("TAG-IMAGE SCREEN", orientation)
    val state by vm.viewState.collectAsState()
    var scale by remember { mutableStateOf(1f) }
    val stateTransform = rememberTransformableState { zoomChange, _, _ ->
        scale *= zoomChange
    }
    var item : String? = null
    state.itemInfo?.let {
        item = it.url
    }

//    BackHandler {
//        Girls2DLikerRouter.navigateTo(Screen.Check)
//    }
    GlideImage(
        model = item,
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