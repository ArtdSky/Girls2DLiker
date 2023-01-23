package com.example.girls2dliker.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.girls2dliker.data.network.ApiService
import com.example.girls2dliker.data.network.dto.Images
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val service: ApiService
) : ViewModel() {
    init {
        loadData()
    }

    data class ViewState(
        val imageList: List<Images> = emptyList(),
        val itemInfo: Images? = null,
        val favoriteList: List<Images> = emptyList()
    )

    private val _viewState = MutableStateFlow(
        ViewState()
    )
    val viewState = _viewState.asStateFlow()

    private val _containInFavorites = MutableStateFlow(false)
    val containInFavorites = _containInFavorites.asStateFlow()

    fun checkInFavorites(value : Boolean){
        _containInFavorites.value = value
    }

    fun updateItemInfo(item: Images) {
        _viewState.update { currentState ->
            currentState.copy(
                itemInfo = item
            )
        }
    }

    fun addToFavorite(item: Images) {
        val oldList = _viewState.value.favoriteList.toMutableList()
        oldList.add(0, item)
        _viewState.update { currentState ->
            currentState.copy(
                favoriteList = oldList
            )
        }
    }

    fun deleteFromFavorite(item: Images) {
        val oldList = _viewState.value.favoriteList.toMutableList()
        oldList.remove(item)
        _viewState.update { currentState ->
            currentState.copy(
                favoriteList = oldList
            )
        }
    }

    fun loadData() {
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