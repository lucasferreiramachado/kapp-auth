package com.lucasferreiramachado.kapp.auth.login.ui.coordinator

import com.lucasferreiramachado.kcoordinator.KCoordinatorAction

sealed class AuthCoordinatorAction: KCoordinatorAction {
    data class StartLogin(val onAuthenticated: OnAuthenticated) : AuthCoordinatorAction()
    data class Authenticated(val username: String) : AuthCoordinatorAction()
    data object GoBack : AuthCoordinatorAction()
}