package com.example.girls2dliker.ui.components

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.rememberTransformableState
import androidx.compose.foundation.gestures.transformable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.girls2dliker.R

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun ScalableImage( imageUrl : String ) {
    var scale by remember { mutableStateOf(1f) }

    val state = rememberTransformableState { zoomChange, _, _ ->
        scale *= zoomChange
    }
    Log.d("SI", imageUrl)
    GlideImage(
        model = imageUrl,
        contentDescription = "test",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .clickable(
                onClick = { Log.d("CH", "Clicked image") }
            )
            .graphicsLayer(
                scaleX = scale,
                scaleY = scale,
            )
            .transformable(state = state)
            .background(Color.Blue)
            .fillMaxSize()
    ){
        it
            .placeholder(R.drawable.ic_android_black_24dp)
            .error(R.drawable.error)
    }

}