package com.example.girls2dliker.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import timber.log.Timber

class MainViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {

    fun onCreateNewNoteClick() {
        Timber.tag("MV").d("FAB CLICK")
    }

    // Define ViewModel factory in a companion object
    companion object {


        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                // Get the Application object from extras
                val application = checkNotNull(extras[APPLICATION_KEY])
                // Create a SavedStateHandle for this ViewModel from extras
                val savedStateHandle = extras.createSavedStateHandle()

                return MainViewModel(
                    savedStateHandle
                ) as T
            }
        }
    }
}