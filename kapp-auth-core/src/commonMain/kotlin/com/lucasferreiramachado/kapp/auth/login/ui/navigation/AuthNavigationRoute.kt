package com.lucasferreiramachado.kapp.auth.login.ui.navigation

import kotlinx.serialization.Serializable

sealed class AuthNavigationRoute {
    @Serializable data object LoginScreen: AuthNavigationRoute()
}