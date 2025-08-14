package com.lucasferreiramachado.kapp.auth.compose.app

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.lucasferreiramachado.kapp.app.coordinators.app.ui.screens.SplashScreen
import com.lucasferreiramachado.kapp.auth.compose.di.ExampleCoordinatorFactory
import com.lucasferreiramachado.kapp.auth.compose.example.ExampleCoordinatorAction
import com.lucasferreiramachado.kcoordinator.KCoordinator
import com.lucasferreiramachado.kcoordinator.KCoordinatorAction
import com.lucasferreiramachado.kcoordinator.compose.RootComposeKCoordinator
import kotlinx.coroutines.delay
import kotlinx.serialization.Serializable

sealed class AppNavigationRoute {
    @Serializable data object SplashScreen: AppNavigationRoute()
}

sealed class AppCoordinatorAction: KCoordinatorAction {
    data object StartExample : AppCoordinatorAction()
}

class AppCoordinator(
    exampleCoordinatorFactory: ExampleCoordinatorFactory = ExampleCoordinatorFactory(),
    override val parent: KCoordinator<*>? = null
) : RootComposeKCoordinator<AppCoordinatorAction> {

    private var exampleCoordinator = exampleCoordinatorFactory.create(parent = this)

    override fun handle(action: AppCoordinatorAction) {
        when (action) {
            is AppCoordinatorAction.StartExample -> {
                exampleCoordinator.trigger(ExampleCoordinatorAction.ShowExampleScreen)
            }
        }
    }

    override fun setupNavigation(
        initialAction: AppCoordinatorAction,
        navGraphBuilder: NavGraphBuilder,
        navHostController: NavHostController,
    ) {
        exampleCoordinator.setupNavigation(navGraphBuilder, navHostController)

        navGraphBuilder.composable<AppNavigationRoute.SplashScreen>() {
            SplashScreen(
                onSplashScreenLaunched = {
                    delay(1500)
                    navHostController.popBackStack()
                    trigger(initialAction)
                }
            )
        }
    }

    @Composable
    override fun start(startDestination: Any, initialAction: AppCoordinatorAction) {
        val navHostController = rememberNavController()

        NavHost(
            startDestination = startDestination,
            navController = navHostController
        ) {
            setupNavigation(
                initialAction,
                this,
                navHostController
            )
        }
    }
}

