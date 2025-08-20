package com.lucasferreiramachado.kapp.auth.compose.example.ui.navigation

import kotlinx.serialization.Serializable

sealed class ExampleNavigationRoute {
    @Serializable data object ExampleScreen: ExampleNavigationRoute()
    @Serializable data object AuthenticatedScreen: ExampleNavigationRoute()
}