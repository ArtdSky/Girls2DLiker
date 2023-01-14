package com.example.girls2dliker.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.girls2dliker.data.network.ApiService
import kotlinx.coroutines.launch
import timber.log.Timber

class MainViewModel(
    private val service: ApiService
) : ViewModel() {

    fun loadList() {
        viewModelScope.launch {
            val res = service.getRandomImg()
            Log.d("TAG-MA", "res.toString()")
        }
    }


    fun onLikeClick() {
        Timber.tag("MV").d("Like CLICK")
    }


}