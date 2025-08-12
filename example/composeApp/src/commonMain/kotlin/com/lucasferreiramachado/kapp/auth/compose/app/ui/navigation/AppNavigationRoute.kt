package com.lucasferreiramachado.kapp.auth.compose.app.ui.navigation

import kotlinx.serialization.Serializable

sealed class AppNavigationRoute {
    @Serializable data object SplashScreen: AppNavigationRoute()
}