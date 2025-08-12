package com.lucasferreiramachado.kapp.auth.compose.example

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.lucasferreiramachado.kapp.auth.login.ui.coordinator.AuthCoordinatorAction
import com.lucasferreiramachado.kapp.auth.compose.example.domain.model.ExampleItem
import com.lucasferreiramachado.kapp.auth.compose.example.ui.screens.authenticated.AuthenticatedUiState
import com.lucasferreiramachado.kapp.auth.compose.example.ui.screens.authenticated.AuthenticatedViewModel
import com.lucasferreiramachado.kapp.auth.compose.example.ui.screens.authenticated.composables.AuthenticatedScreen
import com.lucasferreiramachado.kapp.auth.compose.example.ui.screens.example.ExampleUiState
import com.lucasferreiramachado.kapp.auth.compose.example.ui.screens.example.ExampleViewModel
import com.lucasferreiramachado.kapp.auth.compose.example.ui.screens.example.composables.ExampleScreen
import com.lucasferreiramachado.kapp.auth.compose.di.AuthCoordinatorFactory
import com.lucasferreiramachado.kcoordinator.KCoordinator
import com.lucasferreiramachado.kcoordinator.KCoordinatorAction
import com.lucasferreiramachado.kcoordinator.compose.ComposeKCoordinator
import kotlinx.serialization.Serializable

sealed class ExampleNavigationRoute {
    @Serializable data object ExampleScreen: ExampleNavigationRoute()
    @Serializable data object AuthenticatedScreen: ExampleNavigationRoute()
}

sealed class ExampleCoordinatorAction: KCoordinatorAction {
    data object StartExample : ExampleCoordinatorAction()
    data object StartLoginFlow : ExampleCoordinatorAction()
}

class ExampleCoordinator(
    authCoordinatorFactory: AuthCoordinatorFactory,
    override val parent: KCoordinator<*>? = null
) : ComposeKCoordinator<ExampleCoordinatorAction> {

    private var navHostController: NavHostController? = null

    private var authCoordinator = authCoordinatorFactory.create(parent = this)


    override fun handle(action: ExampleCoordinatorAction) {
        when (action) {
            is ExampleCoordinatorAction.StartExample -> {
                navHostController?.navigate(ExampleNavigationRoute.ExampleScreen)
            }
            ExampleCoordinatorAction.StartLoginFlow -> {
                authCoordinator.trigger(AuthCoordinatorAction.StartLogin {
                    // start any feature you want with an authenticated user
                    navHostController?.navigate(ExampleNavigationRoute.AuthenticatedScreen)
                })
            }
        }
    }

    override fun setupNavigation(
        navGraphBuilder: NavGraphBuilder,
        navHostController: NavHostController,
    ) {
        this.navHostController = navHostController

        authCoordinator.setupNavigation(navGraphBuilder, navHostController)

        navGraphBuilder.composable<ExampleNavigationRoute.ExampleScreen> {
            val items = listOf(
                ExampleItem(
                    name = "Login Flow",
                    action = ExampleCoordinatorAction.StartLoginFlow
                )
            )
            val initialState = ExampleUiState(items = items)
            val viewModel = ExampleViewModel(
                initialState,
                coordinator = this@ExampleCoordinator
            )
            ExampleScreen(viewModel)
        }

        navGraphBuilder.composable<ExampleNavigationRoute.AuthenticatedScreen> {

            val viewModel = AuthenticatedViewModel(
                AuthenticatedUiState(),
                coordinator = this@ExampleCoordinator
            )
            AuthenticatedScreen(viewModel)
        }
    }
}

