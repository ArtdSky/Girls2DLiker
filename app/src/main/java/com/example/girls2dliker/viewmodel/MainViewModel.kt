package com.example.girls2dliker.viewmodel

import android.util.Log
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.girls2dliker.data.network.ApiService
import com.example.girls2dliker.data.network.dto.Images
import com.example.girls2dliker.ui.components.ColorModel
import com.example.girls2dliker.ui.theme.Purple200
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel(
    private val service: ApiService
) : ViewModel() {
    init {
        loadList()
    }

    data class ViewState(
        val imageList: List<Images>,
        val dominantColor : Color
    )

    private val _viewState = MutableStateFlow(
        ViewState(
            imageList = emptyList(),
            dominantColor = Purple200
        )
    )
    val viewState = _viewState.asStateFlow()

    fun updateBgColor(color : Color){
        _viewState.update { currentState ->
            currentState.copy(
                dominantColor = color
            )
        }
    }
    fun loadList() {
        viewModelScope.launch {
            val res = service.getRandomImg()
//            Log.d("TAG-MVM", res.toString())
            _viewState.update { currentState: ViewState ->
                currentState.copy(
                    imageList = res.images,
                )
            }
//            Log.d("TAG-MVM", res.images.toString())

        }
    }


    fun onLikeClick() {
        Timber.tag("MV").d("Like CLICK")
    }


}