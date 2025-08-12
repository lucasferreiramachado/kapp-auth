package com.lucasferreiramachado.kapp.auth.compose.app.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.lucasferreiramachado.kapp.auth.compose.app.ui.coordinator.AppCoordinator
import com.lucasferreiramachado.kapp.auth.compose.app.ui.screens.splash.SplashViewModel
import com.lucasferreiramachado.kapp.auth.compose.app.ui.screens.splash.composables.SplashScreen
import com.lucasferreiramachado.kapp.auth.compose.app.ui.screens.splash.SplashUiState

fun NavGraphBuilder.splashNavigation(
    coordinator: AppCoordinator,
) {
    composable<AppNavigationRoute.SplashScreen> {
        SplashScreen(
            SplashViewModel(
                SplashUiState(),
                coordinator
            )
        )
    }
}