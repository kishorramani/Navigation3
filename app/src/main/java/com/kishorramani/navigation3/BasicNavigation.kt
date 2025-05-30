package com.kishorramani.navigation3

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.lifecycle.viewmodel.navigation3.rememberViewModelStoreNavEntryDecorator
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.runtime.rememberSavedStateNavEntryDecorator
import androidx.navigation3.ui.NavDisplay
import androidx.navigation3.ui.rememberSceneSetupNavEntryDecorator

@Composable
fun BasicNavigation() {
    //val backStack = remember { mutableStateListOf<Screen>(Screen.Home) }      //It's not remember the state of after configuration changes
    //val backStack = rememberNavBackStack<Screen>(Screen.Home)     //It's save state of the home screen - It's survive in the the configuration change

    val viewModel = viewModel<MyViewModel>()
    val backStack = viewModel.backStack

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryDecorators = listOf(
            rememberSceneSetupNavEntryDecorator(),
            rememberSavedStateNavEntryDecorator(),
            rememberViewModelStoreNavEntryDecorator()
        ),
        entryProvider = entryProvider {
            entry<Screen.Home> {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Button (
                        onClick = {
                            backStack.add(Screen.Details(id = "123"))
                        }
                    ) {
                        Text(text = "Go to Details Screen")
                    }
                }
            }
            entry<Screen.Details> { key ->
                val viewModel = viewModel<DetailsViewModel>()
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = "Details ${key.id}")
                }
            }
        }
        /*entryProvider = { key ->
            when (key) {
                is Screen.Home -> NavEntry(key) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Button (
                            onClick = {
                                backStack.add(Screen.Details(id = "123"))
                            }
                        ) {
                            Text(text = "Go to Details Screen")
                        }
                    }
                }

                is Screen.Details -> NavEntry(key) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Details ${key.id}")
                    }
                }
            }
        }*/
    )
}