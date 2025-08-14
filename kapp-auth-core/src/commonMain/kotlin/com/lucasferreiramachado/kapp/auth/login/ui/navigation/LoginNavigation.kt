package com.lucasferreiramachado.kapp.auth.login.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.lucasferreiramachado.kapp.auth.flow.login.ui.screens.login.LoginUiState
import com.lucasferreiramachado.kapp.auth.login.ui.screens.login.LoginViewModel
import com.lucasferreiramachado.kapp.auth.login.ui.screens.login.composables.LoginScreen
import org.koin.compose.viewmodel.koinViewModel
import org.koin.core.parameter.parametersOf

fun NavGraphBuilder.loginNavigation() {
    composable<AuthNavigationRoute.LoginScreen> {
        val viewModel = koinViewModel<LoginViewModel> {
            parametersOf(LoginUiState())
        }
        LoginScreen(viewModel)
    }
}