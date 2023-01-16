package com.example.girls2dliker.viewmodel

import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.girls2dliker.data.network.ApiService
import com.example.girls2dliker.data.network.dto.Images
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
        val itemInfo: Images? = null
    )

    private val _viewState = MutableStateFlow(
        ViewState(
            imageList = emptyList()
        )
    )
    val viewState = _viewState.asStateFlow()

    fun updateItemInfo(item: Images) {
        _viewState.update { currentState ->
            currentState.copy(
                itemInfo = item
            )
        }
    }

    private fun loadList() {
        viewModelScope.launch {
            val res = service.getRandomImg()
            _viewState.update { currentState: ViewState ->
                currentState.copy(
                    imageList = res.images,
                )
            }
        }
    }




}