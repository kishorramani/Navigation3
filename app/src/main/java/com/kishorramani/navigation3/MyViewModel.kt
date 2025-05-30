package com.kishorramani.navigation3

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class MyViewModel: ViewModel() {
    val backStack = mutableStateListOf<Screen>(Screen.Home)
}