package com.lucasferreiramachado.kapp.auth.login.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.lucasferreiramachado.kapp.auth.login.ui.coordinator.AuthCoordinator
import com.lucasferreiramachado.kapp.auth.login.ui.screens.login.LoginViewModel
import com.lucasferreiramachado.kapp.auth.login.ui.screens.login.composables.LoginScreen

fun NavGraphBuilder.loginNavigation(
    coordinator: AuthCoordinator,
) {
    composable<AuthNavigationRoute.LoginScreen> {
        val viewModel = LoginViewModel(
            coordinator = coordinator,
            authenticateUserUseCase = coordinator.factory.authenticateUserUseCase,
            validateUsernameUseCase = coordinator.factory.validateUsernameUseCase,
            validatePasswordUseCase = coordinator.factory.validatePasswordUseCase,
            validateLoginInputUseCase = coordinator.factory.validateLoginInputUseCase,
        )
        LoginScreen(viewModel)
    }
}