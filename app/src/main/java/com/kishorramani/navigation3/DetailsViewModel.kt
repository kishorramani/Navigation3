package com.kishorramani.navigation3

import androidx.lifecycle.ViewModel

class DetailsViewModel: ViewModel() {
    init {
        println("Init Details View Model")
    }

    override fun onCleared() {
        super.onCleared()
        println("Clearing Details View Model...")
    }
}