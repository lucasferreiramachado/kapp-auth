package com.lucasferreiramachado.kapp.auth.login.ui.coordinator

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.lucasferreiramachado.kapp.auth.login.ui.navigation.AuthNavigationRoute
import com.lucasferreiramachado.kapp.auth.login.ui.navigation.loginNavigation
import com.lucasferreiramachado.kcoordinator.KCoordinator
import com.lucasferreiramachado.kcoordinator.compose.ComposeKCoordinator

fun interface OnAuthenticated {
    fun send(username: String)
}

class AuthCoordinator(
    val factory: AuthCoordinatorFactoryI,
    override val parent: KCoordinator<*>,
) : ComposeKCoordinator<AuthCoordinatorAction> {

    private var onAuthenticated: OnAuthenticated? = null
    private var navHostController: NavHostController? = null

    override fun handle(action: AuthCoordinatorAction) {
        when (action) {
            is AuthCoordinatorAction.StartLogin -> {
                onAuthenticated = action.onAuthenticated
                navHostController?.navigate(AuthNavigationRoute.LoginScreen)
            }
            is AuthCoordinatorAction.Authenticated -> {
                val username = action.username
                navHostController?.popBackStack()
                onAuthenticated?.send(username)
            }
            is AuthCoordinatorAction.GoBack -> {
                navHostController?.popBackStack()
            }
        }
    }
    override fun setupNavigation(
        navGraphBuilder: NavGraphBuilder,
        navHostController: NavHostController
    ) {
        this.navHostController = navHostController
        navGraphBuilder.loginNavigation(this)
    }
}