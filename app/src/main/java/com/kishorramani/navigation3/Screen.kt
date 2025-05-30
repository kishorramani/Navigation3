package com.kishorramani.navigation3

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

/*
sealed class Screen {
    data object Home: Screen()
    data class Details(val id: String): Screen()
}*/


sealed class Screen : NavKey {
    @Serializable
    data object Home : Screen()
    @Serializable
    data class Details(val id: String) : Screen()
}